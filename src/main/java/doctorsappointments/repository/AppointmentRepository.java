package doctorsappointments.repository;

import doctorsappointments.entity.Appointment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findByUserId(ObjectId userId);

    Appointment findById(ObjectId id);
}
