package jaefact.branchtest.business.dto.rider;

import jaefact.branchtest.business.domain.rider.Gender;
import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RiderDto {
    private String name;
    private String username;
    private String phone;
    private String email;
    private String carNumber;
    private Gender gender;

    public RiderDto(Rider rider) {
        this.name = rider.getName();
        this.username = rider.getUsername();
        this.phone = rider.getPhone();
        this.email = rider.getEmail();
        this.carNumber = rider.getCarNumber();
        this.gender = rider.getGender();
    }
}
