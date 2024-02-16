package doctorsappointments.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Data
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate dateOfBirth;
    private String password;

}
