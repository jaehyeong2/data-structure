package jaefact.branchtest.business.service.delivery;


import jaefact.branchtest.business.domain.delivery.Delivery;
import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.repository.delivery.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public Delivery getDelivery(Long id){
        return deliveryRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회실패");
        });
    }

    public List<Delivery> getDeliveries(){
        return deliveryRepository.findAll();
    }

    @Transactional
    public Long save(Delivery delivery){
        deliveryRepository.save(delivery);
        return delivery.getId();
    }

    @Transactional
    public Long delete(Long id){
        deliveryRepository.deleteById(id);
        return id;
    }


}
