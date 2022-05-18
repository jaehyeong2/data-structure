package jaefact.branchtest.business.api.rider;

import jaefact.branchtest.business.dto.rider.AuthRes;
import jaefact.branchtest.business.dto.rider.LoginDto;
import jaefact.branchtest.business.dto.rider.RiderSaveReq;
import jaefact.branchtest.business.dto.rider.TokenAndRider;
import jaefact.branchtest.business.service.rider.RiderService;
import jaefact.branchtest.global.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthApi {
    private final RiderService riderService;

    @PostMapping("/signup")
    public AuthRes<String> saveRider(@RequestBody RiderSaveReq dto) throws Exception {
        return new AuthRes<>(riderService.save(dto));
    }

    @PostMapping("/login")
    public ApiResponse<TokenAndRider> login(@Valid @RequestBody LoginDto dto, HttpServletResponse res){
        return new ApiResponse<>(riderService.login(dto,res));
    }

}
