package pl.sda.springboottraining.repository;

import pl.sda.springboottraining.repository.model.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository {

    Integer create(Participant participant);

    void update(Integer id, Participant participant);

    Optional<Participant> findById(Integer id);

    List<Participant> findAll();

    void delete(Integer id);

}
