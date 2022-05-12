package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.dto.user.UserCarNumberDto;
import jaefact.branchtest.business.dto.user.UserEmailDto;
import jaefact.branchtest.business.dto.user.UserPhoneDto;
import jaefact.branchtest.business.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserService userService;

    @GetMapping("/{id}")
    public ApiRes<User> get(@PathVariable Long id){
        return new ApiRes<>(userService.getUser(id));
    }

    @GetMapping("/search/email")
    public UserEmailDto getByEmail(@RequestParam String email){
        return new UserEmailDto(userService.getUserByEmail(email));
    }

    @GetMapping("/search/phone")
    public UserPhoneDto getByPhone(@RequestParam String phone){
        return new UserPhoneDto(userService.getUserByPhone(phone));
    }

    @GetMapping("/search/carnumber")
    public UserCarNumberDto getByCarNumber(@RequestParam String CarNumber){
        return new UserCarNumberDto(userService.getUserByCarNumber(CarNumber));
    }

    @GetMapping("")
    public ApiRes<List<User>> getList(){
        return new ApiRes<>(userService.getUserList());
    }

    @PostMapping("/{id}")
    public ApiRes<Long> save(User user){
        return new ApiRes<>(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ApiRes<Long> delete(Long id){
        return new ApiRes<>(userService.delete(id));
    }
}
