package jaefact.branchtest.business.repository.rider;

import jaefact.branchtest.business.domain.rider.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider,Long> {
    Rider findByUsername(String username);

    Optional<Rider> findByPhone(String phone);
}
