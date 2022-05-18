package jaefact.branchtest.business.dto.rider;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthRes<T> {
    private T result;

    public AuthRes(T result) {
        this.result = result;
    }
}
