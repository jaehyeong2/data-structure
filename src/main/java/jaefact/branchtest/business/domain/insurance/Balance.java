package jaefact.branchtest.business.domain.insurance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Balance {
    @Column(name ="balance_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
