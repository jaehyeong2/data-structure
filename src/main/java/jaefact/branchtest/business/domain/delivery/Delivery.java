package jaefact.branchtest.business.domain.delivery;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
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

}
