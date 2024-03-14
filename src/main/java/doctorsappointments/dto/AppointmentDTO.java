package doctorsappointments.dto;

import doctorsappointments.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class AppointmentDTO {
    private String nameMedicalAppontment;
    private List<String> medicalProcedure;
    private StatusEnum status;
    private String dateMedicalAppontment;
    private String billingDate;
}
