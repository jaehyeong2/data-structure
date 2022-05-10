package jaefact.branchtest.global.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiHeaderResponse {
    private String result_code;
    private String result_message;
}
