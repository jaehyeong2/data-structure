package jaefact.branchtest.business.service.seller;


import jaefact.branchtest.business.repository.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SellerService {

    private final SellerRepository sellerRepository;


}
