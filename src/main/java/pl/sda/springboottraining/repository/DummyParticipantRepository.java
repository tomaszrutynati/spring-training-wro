package pl.sda.springboottraining.repository;

import org.springframework.stereotype.Component;
import pl.sda.springboottraining.repository.model.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DummyParticipantRepository implements ParticipantRepository{

    private Integer id = 1;
    private List<Participant> participants = new ArrayList<>();

    @Override
    public Integer create(Participant participant) {
        Integer newId = id++;
        participant.setId(newId);
        participants.add(participant);
        return newId;
    }

    @Override
    public void update(Integer id, Participant participant) {
        if (participants.stream().noneMatch(pt -> pt.getId().equals(id))) {
            throw new IllegalStateException("Participant not exists");
        }
        participants.removeIf(pt -> pt.getId().equals(id));
        participant.setId(id);
        participants.add(participant);
    }

    @Override
    public Optional<Participant> findById(Integer id) {
        return participants.stream()
                .filter(pt -> pt.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Participant> findAll() {
        return participants;
    }

    @Override
    public void delete(Integer id) {
        participants.removeIf(pt -> pt.getId().equals(id));
    }
}
