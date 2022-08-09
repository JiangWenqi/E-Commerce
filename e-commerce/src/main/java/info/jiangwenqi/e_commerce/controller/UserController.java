package info.jiangwenqi.e_commerce.controller;

import info.jiangwenqi.e_commerce.dto.user.SignInDto;
import info.jiangwenqi.e_commerce.dto.user.SignInResponseDto;
import info.jiangwenqi.e_commerce.dto.user.SignupDto;
import info.jiangwenqi.e_commerce.dto.user.SignupResponseDto;
import info.jiangwenqi.e_commerce.exception.AuthenticationException;
import info.jiangwenqi.e_commerce.exception.CustomException;
import info.jiangwenqi.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenqi
 */
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignupResponseDto signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signup(signupDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) throws CustomException, AuthenticationException {
        return userService.signIn(signInDto);
    }
}
