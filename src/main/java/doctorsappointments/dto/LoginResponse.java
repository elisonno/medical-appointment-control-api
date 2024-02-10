package doctorsappointments.dto;

import doctorsappointments.entity.User;

import java.util.Date;

public class LoginResponse {
    private String name;
    private String email;
    private String cpf;
    private Date dateOfBirth;

    public LoginResponse(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.dateOfBirth = user.getDateOfBirth();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
