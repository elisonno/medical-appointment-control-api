package doctorsappointments.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class UpdateRequest {
    private ObjectId appointmentId;
}
