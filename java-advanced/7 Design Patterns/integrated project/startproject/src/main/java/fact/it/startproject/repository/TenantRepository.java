package fact.it.startproject.repository;

import fact.it.startproject.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
    List<Tenant> findByIncomeLessThan(double income);
}
