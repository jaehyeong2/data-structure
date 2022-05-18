package jaefact.branchtest.business.dto.rider;

import jaefact.branchtest.business.domain.rider.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TokenAndRider extends RiderDto{
    private String token;

    public TokenAndRider(String token) {
        this.token = token;
    }

    public TokenAndRider(Rider rider, String token) {
        super(rider);
        this.token = token;
    }
}
