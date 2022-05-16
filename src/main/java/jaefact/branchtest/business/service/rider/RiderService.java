package jaefact.branchtest.business.service.rider;

import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.dto.rider.RiderSaveReq;
import jaefact.branchtest.business.repository.rider.RiderRepository;
import jaefact.branchtest.business.repository.rider.RiderRepositorySupport;
import jaefact.branchtest.business.repository.seller.SellerRepository;
import jaefact.branchtest.global.error.exception.BusinessException;
import jaefact.branchtest.global.error.model.ErrorCode;
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
    private final SellerRepository sellerRepository;

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


    //회원가입
    @Transactional
    public Long save(RiderSaveReq dto) throws Exception {
        Seller seller = sellerRepository.findById(dto.getSeller_id()).orElseThrow(() -> {
            throw new NoSuchElementException("조회 실패");
        });
        String ssn = dto.getSsn();
        ssnCheck(ssn);
        String encodeSsn = ssnEncode(ssn);

        Rider rider = Rider.create(seller, dto,encodeSsn);
        riderRepository.save(rider);
        return rider.getId();
    }

    @Transactional
    public Long delete(Long id){
        riderRepository.deleteById(id);
        return id;
    }


    private String ssnEncode(String ssn) throws Exception {
        AES_Encryption aes = new AES_Encryption();
        String encrypt = aes.encrypt(ssn);
        return encrypt;
    }

    private String ssnDecode(String ssn) throws Exception {
        AES_Encryption aes = new AES_Encryption();
        String decrypt = aes.decrypt(ssn);
        return decrypt;
    }

    public void ssnCheck(String number){
        hyphenCheck(number);
        ssnLengthCheck(number);
    }

    private void hyphenCheck(String number) {
        if (number.contains("-") || (!number.matches("[+-]?\\d*(\\.\\d+)?"))){
            throw new BusinessException(ErrorCode.INVALID_TYPE_VALUE2);
        }
    }

    private void ssnLengthCheck(String number) {
        if (number.length() != 13) {
            throw new BusinessException(ErrorCode.INVALID_LENGTH_VALUE);
        }
    }



}
