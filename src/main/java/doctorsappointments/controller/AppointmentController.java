package doctorsappointments.controller;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import doctorsappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/new")
    public void newMedicalAppointment(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.newMedicalAppointment(appointmentRequest);
    }

    @GetMapping("/my/{userId}")
    public AppointmentResponse myAppointments(@PathVariable ObjectId userId){
        return appointmentService.appointments(userId);
    }
}
