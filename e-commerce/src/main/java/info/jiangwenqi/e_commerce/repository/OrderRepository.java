package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.Order;
import info.jiangwenqi.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}
