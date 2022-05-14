package jaefact.branchtest.business.service.insurance;


import jaefact.branchtest.business.domain.insurance.InsuranceHistory;
import jaefact.branchtest.business.repository.insurance.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class InsuranceService {

    private final HistoryRepository historyRepository;

    public InsuranceHistory getHistory(Long id){
        return historyRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public List<InsuranceHistory> getHistories(){
        return historyRepository.findAll();
    }

    @Transactional
    public Long save(InsuranceHistory insuranceHistory){
        historyRepository.save(insuranceHistory);
        return insuranceHistory.getId();
    }

    @Transactional
    public Long delete(Long id){
        historyRepository.deleteById(id);
        return id;
    }


}
