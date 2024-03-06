package doctorsappointments.entity;


import doctorsappointments.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@Document(collection = "Appointment")
public class Appointment {

    @Id
    private String id;
    private ObjectId userId;
    private String nameMedicalAppontment;
    private List<String> medicalProcedure;
    private StatusEnum status;
    private LocalDate dateMedicalAppontment;

}
