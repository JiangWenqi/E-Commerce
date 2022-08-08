package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.dto.user.SignupDto;
import info.jiangwenqi.e_commerce.dto.user.SignupResponseDto;
import info.jiangwenqi.e_commerce.exception.CustomException;
import info.jiangwenqi.e_commerce.model.AuthenticationToken;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.repository.UserRepository;
import info.jiangwenqi.e_commerce.util.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author wenqi
 */

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public SignupResponseDto signup(SignupDto signupDto) throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("User already exists");
        }
        // first encrypt the password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = Generator.hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }
        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedPassword);
        try {
            // save the User
            userRepository.save(user);
            // generate token for user
            final AuthenticationToken authenticationToken = new AuthenticationToken(user);
            // save token in database
            authenticationTokenService.saveConfirmationToken(authenticationToken);
            // success in creating
            return new SignupResponseDto(1, "user created successfully");
        } catch (Exception e) {
            // handle signup error
            throw new CustomException(e.getMessage());
        }
    }
}
