package jaefact.branchtest.business.dto.user;

import jaefact.branchtest.business.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPhoneDto {
    private String phone;
    private String name;

    public UserPhoneDto(User user) {
        this.phone = user.getPhone();
        this.name = user.getName();
    }
}
