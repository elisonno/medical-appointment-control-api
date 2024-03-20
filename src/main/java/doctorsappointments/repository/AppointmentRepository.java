package doctorsappointments.repository;

import doctorsappointments.entity.Appointment;
import doctorsappointments.enums.StatusEnum;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findByUserIdAndStatus(ObjectId userId, StatusEnum status);

    Appointment findById(ObjectId id);
}
