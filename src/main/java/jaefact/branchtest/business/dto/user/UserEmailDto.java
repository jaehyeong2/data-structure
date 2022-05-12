package jaefact.branchtest.business.dto.user;

import jaefact.branchtest.business.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEmailDto {
    private String email;
    private String name;

    public UserEmailDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
}
