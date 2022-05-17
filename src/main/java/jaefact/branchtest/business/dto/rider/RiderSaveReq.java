package jaefact.branchtest.business.dto.rider;

import jaefact.branchtest.business.domain.rider.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RiderSaveReq {
    private String name;
    private String username;
    private String phone;
    private String email;
    private String carNumber;
    private String ssn;
    private Gender gender;
    private String password;

    private Long seller_id;
}
