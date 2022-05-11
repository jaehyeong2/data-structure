package jaefact.branchtest.business.repository.insurance;

import jaefact.branchtest.business.domain.insurance.InsuranceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<InsuranceHistory,Long> {
}
