package jaefact.branchtest.business.dto.user;

import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCarNumberDto {
    private String carNumber;
    private String name;

    public UserCarNumberDto(Rider rider) {
        this.carNumber = rider.getCarNumber();
        this.name = rider.getName();
    }
}
