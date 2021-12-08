package jaefact.branchtest.service;

import jaefact.branchtest.domain.user.User;
import jaefact.branchtest.domain.user.UserRepository;
import jaefact.branchtest.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public void join(User user){
        userRepository.save(user);
    }
}
