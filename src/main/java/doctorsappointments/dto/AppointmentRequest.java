package doctorsappointments.dto;

import doctorsappointments.enums.StatusEnum;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class AppointmentRequest {

    private ObjectId userId;
    private String nameMedicalAppontment;
    private List<String> medicalProcedure;
    private StatusEnum status;

}
