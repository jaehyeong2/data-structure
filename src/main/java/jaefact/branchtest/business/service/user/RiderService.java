package jaefact.branchtest.business.service.user;

import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.repository.user.RiderRepository;
import jaefact.branchtest.business.repository.user.RiderRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RiderService {

    private final RiderRepository riderRepository;
    private final RiderRepositorySupport userRepositorySupport;

    public Rider getUser(Long id){
        return riderRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public Rider getUserByEmail(String email){
        return userRepositorySupport.findByEmail(email);
    }

    public Rider getUserByPhone(String phone){
        return userRepositorySupport.findByPhone(phone);
    }

    public Rider getUserByCarNumber(String carNumber){
        return userRepositorySupport.findByCarNumber(carNumber);
    }

    public List<Rider> getUserList(){
        return riderRepository.findAll();
    }

    @Transactional
    public Long save(Rider rider){
        riderRepository.save(rider);
        return rider.getId();
    }

    @Transactional
    public Long delete(Long id){
        riderRepository.deleteById(id);
        return id;
    }
}
