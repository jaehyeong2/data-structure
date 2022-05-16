package jaefact.branchtest.business.repository.rider;

import jaefact.branchtest.business.domain.rider.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Long> {
    Rider findByUsername(String username);
}
