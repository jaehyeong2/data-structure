package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.delivery.Delivery;
import jaefact.branchtest.business.domain.insurance.InsuranceHistory;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.service.insurance.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/history")
@RequiredArgsConstructor
@RestController
public class HistoryApi {
    private final InsuranceService insuranceService;

    @GetMapping("/{id}")
    public ApiRes<InsuranceHistory> get(@RequestBody @PathVariable Long id){
        return new ApiRes<>(insuranceService.getHistory(id));
    }

    @GetMapping("")
    public ApiRes<List<InsuranceHistory>> getList(){
        return new ApiRes<>(insuranceService.getHistories());
    }

    @PostMapping("/{id}")
    public ApiRes<Long> save(InsuranceHistory history){
        return new ApiRes<>(insuranceService.save(history));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(insuranceService.delete(id));
    }
}
