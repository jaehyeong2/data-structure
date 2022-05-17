package jaefact.branchtest.business.dto.delivery;

import jaefact.branchtest.business.domain.delivery.Delivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private Long rider_id;

    private String pickUpAddress;
    private String deliveryAddress;

    public DeliveryDto(Delivery delivery) {
        this.rider_id = delivery.getRider().getId();
        this.pickUpAddress = delivery.getPickUpAddress();
        this.deliveryAddress = delivery.getDeliveryAddress();
     }
}
