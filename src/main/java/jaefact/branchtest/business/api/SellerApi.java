package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.insurance.InsuranceHistory;
import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sellers")
@RequiredArgsConstructor
@RestController
public class SellerApi {
    private final SellerService sellerService;

    @GetMapping("/{id}")
    public ApiRes<Seller> get(@RequestBody @PathVariable Long id){
        return new ApiRes<>(sellerService.getSeller(id));
    }

    @GetMapping("")
    public ApiRes<List<Seller>> getList(){
        return new ApiRes<>(sellerService.getSellers());
    }

    @PostMapping("/{id}")
    public ApiRes<Long> save(Seller seller){
        return new ApiRes<>(sellerService.save(seller));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(sellerService.delete(id));
    }
}
