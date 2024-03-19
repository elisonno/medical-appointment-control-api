package doctorsappointments.service.impl;

import doctorsappointments.dto.AppointmentDTO;
import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import doctorsappointments.dto.UpdateRequest;
import doctorsappointments.entity.Appointment;
import doctorsappointments.enums.StatusEnum;
import doctorsappointments.repository.AppointmentRepository;
import doctorsappointments.service.AppointmentService;
import doctorsappointments.util.DateUtility;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public void changingMedicalAppointmentStatus(UpdateRequest updateRequest) {
        var appointment = appointmentRepository.findById(updateRequest.getAppointmentId());
        if (StatusEnum.CHARGED.equals(appointment.getStatus())) {
            appointment.setStatus(StatusEnum.NOT_CHARGED);
        } else {
            appointment.setStatus(StatusEnum.CHARGED);
        }
        appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentResponse myAppointments(ObjectId userId, int month, int year) {
        var appointments = listMedicalAppointments(userId);
        List<AppointmentDTO> myAppointments = new ArrayList<>();
        for (Appointment actual : appointments) {
            if ((actual.getBillingDate().getMonthValue() == month) && (actual.getBillingDate().getYear() == year)) {
                var actualAppointment = AppointmentDTO.builder()
                        .nameMedicalAppontment(actual.getNameMedicalAppontment())
                        .medicalProcedure(actual.getMedicalProcedure())
                        .status(actual.getStatus())
                        .dateMedicalAppontment(DateUtility.convertFormat(actual.getDateMedicalAppontment()))
                        .billingDate(DateUtility.convertFormat(actual.getBillingDate()))
                        .build();
                myAppointments.add(actualAppointment);
            }
        }
        return AppointmentResponse.builder()
                .appointments(myAppointments)
                .build();
    }

    @Override
    public AppointmentResponse appointments(ObjectId userId) {
        var appointments = listMedicalAppointments(userId);
        List<AppointmentDTO> myAppointments = new ArrayList<>();
        for (Appointment actual : appointments) {
            var actualAppointment = AppointmentDTO.builder()
                    .nameMedicalAppontment(actual.getNameMedicalAppontment())
                    .medicalProcedure(actual.getMedicalProcedure())
                    .status(actual.getStatus())
                    .dateMedicalAppontment(DateUtility.convertFormat(actual.getDateMedicalAppontment()))
                    .billingDate(DateUtility.convertFormat(actual.getBillingDate()))
                    .build();
            myAppointments.add(actualAppointment);
        }

        return AppointmentResponse.builder()
                .appointments(myAppointments)
                .build();
    }

    @Override
    public void newMedicalAppointment(AppointmentRequest appointmentRequest) {

        var appointment = Appointment.builder()
                .userId(appointmentRequest.getUserId())
                .nameMedicalAppontment(appointmentRequest.getNameMedicalAppontment())
                .medicalProcedure(appointmentRequest.getMedicalProcedure())
                .status(appointmentRequest.getStatus())
                .dateMedicalAppontment(LocalDate.now())
                .billingDate(LocalDate.now().plusMonths(3))
                .build();
        appointmentRepository.save(appointment);
    }

    private List<Appointment> listMedicalAppointments(ObjectId userId) {
        return appointmentRepository.findByUserId(userId);
    }

}
