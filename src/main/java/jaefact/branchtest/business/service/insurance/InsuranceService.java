package jaefact.branchtest.business.service.insurance;


import jaefact.branchtest.business.repository.insurance.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class InsuranceService {

    private final HistoryRepository historyRepository;


}
