package jaefact.branchtest.business.service.seller;


import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.domain.user.User;
import jaefact.branchtest.business.repository.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public Seller getSeller(Long id){
        return sellerRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public List<Seller> getSellers(){
        return sellerRepository.findAll();
    }

    @Transactional
    public Long save(Seller seller){
        sellerRepository.save(seller);
        return seller.getId();
    }

    @Transactional
    public Long delete(Long id){
        sellerRepository.deleteById(id);
        return id;
    }
}
