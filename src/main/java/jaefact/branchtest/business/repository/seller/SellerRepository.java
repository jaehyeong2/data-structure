package jaefact.branchtest.business.repository.seller;

import jaefact.branchtest.business.domain.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
