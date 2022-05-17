package jaefact.branchtest.business.service.delivery;


import jaefact.branchtest.business.domain.delivery.Delivery;
import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.dto.delivery.DeliveryDto;
import jaefact.branchtest.business.repository.delivery.DeliveryRepository;
import jaefact.branchtest.business.repository.rider.RiderRepository;
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
    private final RiderRepository riderRepository;

    public DeliveryDto getDelivery(Long id){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });
        DeliveryDto dto = new DeliveryDto(delivery);
        return dto;
    }

    public List<Delivery> getDeliveries(){
        return deliveryRepository.findAll();
    }

    @Transactional
    public Long save(DeliveryDto dto){
        Rider rider = findById(dto);
        Delivery delivery = Delivery.create(dto,rider);

        deliveryRepository.save(delivery);
        return delivery.getId();
    }


    @Transactional
    public Long delete(Long id){
        deliveryRepository.deleteById(id);
        return id;
    }

    private Rider findById(DeliveryDto dto) {
        return riderRepository.findById(dto.getRider_id()).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });
    }

}
