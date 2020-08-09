package pl.sda.springboottraining.repository.model;

import lombok.*;

@Setter
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
