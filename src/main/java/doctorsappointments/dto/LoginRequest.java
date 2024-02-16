package doctorsappointments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@Getter
public class LoginRequest {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
