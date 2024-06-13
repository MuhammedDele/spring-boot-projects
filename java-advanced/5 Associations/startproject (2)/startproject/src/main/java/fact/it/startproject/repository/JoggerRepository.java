package fact.it.startproject.repository;

import fact.it.startproject.model.Jogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoggerRepository extends JpaRepository<Jogger, Long> {
}
