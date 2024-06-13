package fact.it.startproject.repository;

import fact.it.startproject.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query("select t from Training t order by t.theme asc ")
    public List<Training> findAllOrderByThemesAsc();
    @Query("SELECT DISTINCT t.theme FROM Training t ORDER BY t.theme ASC")
    public List<String> findAllUniqueThemes();
    @Query("SELECT t FROM Training t WHERE t.title = :title ORDER BY t.theme ASC")
    public List<Training> findByTitle(String title);
}
