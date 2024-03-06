package doctorsappointments.service;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.entity.Appointment;
import org.bson.types.ObjectId;

import java.util.List;

public interface AppointmentService {

    List<Appointment> appontmests(ObjectId userId);

    void newMedicalAppointment(AppointmentRequest appointmentRequest);
}
