package doctorsappointments.service;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import org.bson.types.ObjectId;

public interface AppointmentService {

    AppointmentResponse appointments(ObjectId userId);

    void newMedicalAppointment(AppointmentRequest appointmentRequest);
}
