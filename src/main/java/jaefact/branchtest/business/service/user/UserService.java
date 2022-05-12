package jaefact.branchtest.business.service.user;

import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Transactional
    public Long save(User user){
        userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Long delete(Long id){
        userRepository.deleteById(id);
        return id;
    }
}
