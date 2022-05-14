package jaefact.branchtest.global.config;

import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.repository.user.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomDetailsService implements UserDetailsService {
    private final RiderRepository riderRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Rider rider = riderRepository.findByUsername(username);
        return rider;
    }
}
