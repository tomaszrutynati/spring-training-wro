package pl.sda.springboottraining.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    private Integer id;
    private String firstName;
    private String lastName;
    private String idNumber;
}
