package jaefact.branchtest.business.repository.delivery;

import jaefact.branchtest.business.domain.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
