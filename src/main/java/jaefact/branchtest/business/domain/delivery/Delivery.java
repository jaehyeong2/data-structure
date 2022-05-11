package jaefact.branchtest.business.domain.delivery;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Delivery extends BaseTimeEntity {

    @Column(name ="delivery_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
