package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.models.entities.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {

    Optional<Store> findByName(String name);

}
