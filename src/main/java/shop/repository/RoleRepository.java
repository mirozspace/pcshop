package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entities.URole;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <URole, String> {

    Optional<URole> findByAuthority (String authority);

}
