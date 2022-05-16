package jaefact.branchtest.business.dto.rider;

import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPhoneDto {
    private String phone;
    private String name;

    public UserPhoneDto(Rider rider) {
        this.phone = rider.getPhone();
        this.name = rider.getName();
    }
}
