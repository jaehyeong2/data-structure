package jaefact.branchtest.controller;

import jaefact.branchtest.domain.user.User;
import jaefact.branchtest.dto.SignUpDto;
import jaefact.branchtest.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "/auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid SignUpDto signUpDto, BindingResult bindingResult){
        User user = signUpDto.toEntity();
        authService.join(user);
        return "/auth/signup";
    }
}
