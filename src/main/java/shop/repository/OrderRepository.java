package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
