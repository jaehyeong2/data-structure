package jaefact.branchtest.business.domain.insurance;

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
public class InsuranceHistory extends BaseTimeEntity {

    @Column(name ="history_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
