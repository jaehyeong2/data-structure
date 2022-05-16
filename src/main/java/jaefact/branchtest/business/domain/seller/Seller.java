package jaefact.branchtest.business.domain.seller;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.dto.seller.SellerDto;
import lombok.*;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Seller extends BaseTimeEntity {

    @Column(name ="seller_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String tell;

    public static Seller create(SellerDto dto){
        return new Seller().builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .tell(dto.getTell())
                .build();
    }
}
