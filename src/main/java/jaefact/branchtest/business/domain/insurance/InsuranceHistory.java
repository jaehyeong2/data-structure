package jaefact.branchtest.business.domain.insurance;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.domain.rider.Rider;
import jaefact.branchtest.business.dto.insurance.InsuranceHistoryDto;
import lombok.*;

import javax.persistence.*;

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

    @Builder
    public InsuranceHistory(Rider rider, String result, String reason, Integer until) {
        this.rider = rider;
        this.result = result;
        this.reason = reason;
        this.until = until;
    }

    public static InsuranceHistory create(InsuranceHistoryDto dto,Rider rider){
        return new InsuranceHistory().builder()
                .result(dto.getResult())
                .reason(dto.getReason())
                .until(dto.getUntil())
                .build();
    }
}
