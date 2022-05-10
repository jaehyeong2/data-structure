package jaefact.branchtest.business.service;

import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.domain.user.UserRepository;
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
