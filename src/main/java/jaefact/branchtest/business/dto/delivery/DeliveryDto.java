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
    private String pickUpAddress;
    private String deliveryAddress;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
