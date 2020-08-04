package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
