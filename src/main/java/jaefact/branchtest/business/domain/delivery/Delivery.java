package jaefact.branchtest.business.domain.delivery;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.dto.delivery.DeliveryDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Delivery extends BaseTimeEntity {

    @Column(name ="delivery_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "rider_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    private String pickUpAddress;
    private String deliveryAddress;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Builder
    public Delivery(Rider rider, String pickUpAddress, String deliveryAddress, LocalDateTime startTime, LocalDateTime endTime) {
        this.rider = rider;
        this.pickUpAddress = pickUpAddress;
        this.deliveryAddress = deliveryAddress;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Delivery create(DeliveryDto dto,Rider rider){
        return new Delivery().builder()
                .pickUpAddress(dto.getPickUpAddress())
                .deliveryAddress(dto.getDeliveryAddress())
                .startTime(LocalDateTime.now())
                .rider(rider)
                .build();
    }
}
