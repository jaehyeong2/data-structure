package jaefact.branchtest.business.api;

import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.dto.ApiRes;
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
    public ApiRes<User> get(@RequestBody @PathVariable Long id){
        return new ApiRes<>(userService.getUser(id));
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
