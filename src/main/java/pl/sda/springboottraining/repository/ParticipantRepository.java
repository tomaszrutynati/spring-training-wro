package pl.sda.springboottraining.repository;

import pl.sda.springboottraining.repository.model.Participant;

import java.util.List;

public interface ParticipantRepository {

    Integer create(Participant participant);

    void update(Integer id, Participant participant);

    Participant findById(Integer id);

    List<Participant> findAll();

    void delete(Integer id);

}
