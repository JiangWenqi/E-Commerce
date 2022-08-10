package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.exception.AuthenticationFailException;
import info.jiangwenqi.e_commerce.model.AuthenticationToken;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.repository.AuthenticationTokenRepository;
import info.jiangwenqi.e_commerce.config.MessageStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author wenqi
 */
@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationTokenRepository repository;

    /**
     * save the confirmation token
     *
     * @param authenticationToken token
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
     * @throws AuthenticationFailException authentication failed
     */
    public void authenticate(String token) throws AuthenticationFailException {
        if (!Objects.nonNull(token)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if (!Objects.nonNull(getUser(token))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }
}
