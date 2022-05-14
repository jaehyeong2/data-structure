package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.dto.user.UserCarNumberDto;
import jaefact.branchtest.business.dto.user.UserEmailDto;
import jaefact.branchtest.business.dto.user.UserPhoneDto;
import jaefact.branchtest.business.service.user.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserApi {
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

    @PostMapping("/{id}")
    public ApiRes<Long> save(Rider rider){
        return new ApiRes<>(riderService.save(rider));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(riderService.delete(id));
    }
}
