package jaefact.branchtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "/auth/signup";
    }
}
