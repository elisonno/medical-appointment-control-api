package doctorsappointments.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class LoginResponse {
    private String id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate dateOfBirth;

}
