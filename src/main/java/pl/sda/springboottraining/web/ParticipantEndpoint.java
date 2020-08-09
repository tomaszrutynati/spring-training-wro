package pl.sda.springboottraining.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springboottraining.repository.ParticipantRepository;
import pl.sda.springboottraining.repository.model.Participant;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/participant")
@RequiredArgsConstructor
public class ParticipantEndpoint {

    private final ParticipantRepository participantRepository;

    @GetMapping
    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    // /participant/1
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        Optional<Participant> participant = participantRepository.findById(id);
        //zwroc status 200 jesli kursant istnieje, lub 404 gdy nie istnieje
        return participant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//zawsze zwracaj status 201 gdy dodanie
    //sie powiodlo
    public Integer create(@RequestBody Participant participant) {
        return participantRepository.create(participant);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody Participant participant) {
        participantRepository.update(id, participant);
    }

    // /participant?participantId=1
    @DeleteMapping
    public void delete(@RequestParam("participantId") Integer id) {
        participantRepository.delete(id);
    }
}
