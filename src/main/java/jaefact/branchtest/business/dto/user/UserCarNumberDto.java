package jaefact.branchtest.business.dto.user;

import jaefact.branchtest.business.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCarNumberDto {
    private String carNumber;
    private String name;

    public UserCarNumberDto(User user) {
        this.carNumber = user.getCarNumber();
        this.name = user.getName();
    }
}
