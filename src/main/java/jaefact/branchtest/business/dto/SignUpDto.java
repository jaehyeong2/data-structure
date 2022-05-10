package jaefact.branchtest.business.dto;

import jaefact.branchtest.business.domain.user.User;
import lombok.Data;

@Data
public class SignUpDto {

    private String name;
    private String username;
    private String password;
    private String email;

    public User toEntity(){
        return User.builder().name(name)
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
