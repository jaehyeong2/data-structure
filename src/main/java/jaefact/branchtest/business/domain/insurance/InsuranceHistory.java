package jaefact.branchtest.business.domain.insurance;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class InsuranceHistory extends BaseTimeEntity {

    @Column(name ="history_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name ="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    private String result;
    private String reason;
    private Integer until;
}
