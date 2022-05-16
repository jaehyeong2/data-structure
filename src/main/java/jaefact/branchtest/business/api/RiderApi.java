package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.dto.rider.RiderSaveReq;
import jaefact.branchtest.business.dto.rider.UserCarNumberDto;
import jaefact.branchtest.business.dto.rider.UserEmailDto;
import jaefact.branchtest.business.dto.rider.UserPhoneDto;
import jaefact.branchtest.business.service.rider.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/riders")
@RequiredArgsConstructor
@RestController
public class RiderApi {
    private final RiderService riderService;

    @GetMapping("/{id}")
    public ApiRes<Rider> get(@PathVariable Long id){
        return new ApiRes<>(riderService.getUser(id));
    }

    @GetMapping("/search/email")
    public UserEmailDto getByEmail(@RequestParam String email){
        return new UserEmailDto(riderService.getUserByEmail(email));
    }

    @GetMapping("/search/phone")
    public UserPhoneDto getByPhone(@RequestParam String phone){
        return new UserPhoneDto(riderService.getUserByPhone(phone));
    }

    @GetMapping("/search/carnumber")
    public UserCarNumberDto getByCarNumber(@RequestParam String CarNumber){
        return new UserCarNumberDto(riderService.getUserByCarNumber(CarNumber));
    }

    @GetMapping("")
    public ApiRes<List<Rider>> getList(){
        return new ApiRes<>(riderService.getUserList());
    }

    @PostMapping("")
    public ApiRes<Long> save(@RequestBody RiderSaveReq dto){
        return new ApiRes<>(riderService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(riderService.delete(id));
    }
}
