package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entities.ReturnQuery;

@Repository
public interface ReturnQueryRepository extends JpaRepository<ReturnQuery, String> {
}
