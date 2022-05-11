package jaefact.branchtest.business.repository.seller;

import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
