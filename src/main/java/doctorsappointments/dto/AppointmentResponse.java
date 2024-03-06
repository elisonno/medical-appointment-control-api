package doctorsappointments.dto;

import doctorsappointments.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class AppointmentResponse {
    private String nameMedicalAppontment;
    private List<String> medicalProcedure;
    private StatusEnum status;
    private LocalDate dateMedicalAppontment;
}
