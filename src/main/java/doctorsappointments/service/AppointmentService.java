package doctorsappointments.service;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import doctorsappointments.entity.Appointment;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {

    AppointmentResponse appointments(ObjectId userId);

    void newMedicalAppointment(AppointmentRequest appointmentRequest);
}
