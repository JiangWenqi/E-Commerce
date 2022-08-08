package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenqi
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * @param email user's e-mail
     * @return User
     */
    User findByEmail(String email);
}
