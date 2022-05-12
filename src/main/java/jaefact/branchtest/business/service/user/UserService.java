package jaefact.branchtest.business.service.user;

import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.dto.ApiRes;
import jaefact.branchtest.business.dto.user.UserEmailDto;
import jaefact.branchtest.business.repository.user.UserRepository;
import jaefact.branchtest.business.repository.user.UserRepositorySupport;
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
    private final UserRepositorySupport userRepositorySupport;

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public User getUserByEmail(String email){
        return userRepositorySupport.findByEmail(email);
    }

    public User getUserByPhone(String phone){
        return userRepositorySupport.findByPhone(phone);
    }

    public User getUserByCarNumber(String carNumber){
        return userRepositorySupport.findByCarNumber(carNumber);
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
