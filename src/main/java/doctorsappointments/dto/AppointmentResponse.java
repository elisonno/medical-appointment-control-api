package doctorsappointments.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppointmentResponse {
    private List<AppointmentDTO> appointments;

}
