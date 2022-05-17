package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.delivery.Delivery;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.dto.delivery.DeliveryDto;
import jaefact.branchtest.business.service.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/delivery")
@RequiredArgsConstructor
@RestController
public class DeliveryApi {

    private final DeliveryService deliveryService;

    @GetMapping("/{id}")
    public ApiRes<DeliveryDto> get(@PathVariable Long id){
        return new ApiRes<>(deliveryService.getDelivery(id));
    }

    @GetMapping("")
    public ApiRes<List<Delivery>> getList(){
        return new ApiRes<>(deliveryService.getDeliveries());
    }

    @PostMapping("")
    public ApiRes<Long> save(@RequestBody DeliveryDto dto){
        return new ApiRes<>(deliveryService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(deliveryService.delete(id));
    }
}
