package jaefact.branchtest.business.dto.user;

import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEmailDto {
    private String email;
    private String name;

    public UserEmailDto(Rider rider) {
        this.email = rider.getEmail();
        this.name = rider.getName();
    }
}
