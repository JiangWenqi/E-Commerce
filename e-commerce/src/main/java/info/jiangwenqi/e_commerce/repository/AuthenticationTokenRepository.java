package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.AuthenticationToken;
import info.jiangwenqi.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenqi
 */
@Repository
public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    /**
     * @param user
     * @return
     */
    AuthenticationToken findTokenByUser(User user);

    /**
     * @param token
     * @return
     */
    AuthenticationToken findTokenByToken(String token);


}