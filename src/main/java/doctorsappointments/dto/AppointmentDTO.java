package doctorsappointments.dto;

import doctorsappointments.enums.BillingStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppointmentDTO {
    private String nameMedicalAppontment;
    private List<String> medicalProcedure;
    private BillingStatusEnum status;
    private String dateMedicalAppontment;
    private String billingDate;
}
