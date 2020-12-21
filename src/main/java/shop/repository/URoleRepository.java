package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entities.Authority;

import java.util.Optional;

@Repository
public interface URoleRepository extends JpaRepository <Authority, String> {

    Optional<Authority> findByAuthority (String authority);

}
