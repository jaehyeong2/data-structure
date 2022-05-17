package jaefact.branchtest.business.dto.insurance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InsuranceHistoryDto {
    private String result;
    private String reason;
    private Integer until;
}
