package doctorsappointments.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignInRequest {

    private String name;
    private String email;
    private String cpf;
    private LocalDate dateOfBirth;
    private String password;

}
