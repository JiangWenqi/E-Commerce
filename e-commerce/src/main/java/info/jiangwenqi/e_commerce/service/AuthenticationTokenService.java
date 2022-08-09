package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.exception.AuthenticationException;
import info.jiangwenqi.e_commerce.model.AuthenticationToken;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.repository.AuthenticationTokenRepository;
import info.jiangwenqi.e_commerce.util.MessageStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationTokenRepository repository;

    /**
     * save the confirmation token
     *
     * @param authenticationToken
     */
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

    /**
     * get token of the User
     *
     * @param user user
     * @return token
     */
    public AuthenticationToken getToken(User user) {
        return repository.findTokenByUser(user);
    }

    /**
     * get Uer from the token
     *
     * @param token token
     * @return user
     */

    public User getUser(String token) {
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        if (Objects.nonNull(authenticationToken) && Objects.nonNull(authenticationToken.getUser())) {
            return authenticationToken.getUser();
        }
        return null;
    }

    /**
     * check if the token is valid
     *
     * @param token token
     * @throws AuthenticationException authentication failed
     */
    public void authenticate(String token) throws AuthenticationException {
        if (!Objects.nonNull(token)) {
            throw new AuthenticationException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if (!Objects.nonNull(getUser(token))) {
            throw new AuthenticationException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }
}
