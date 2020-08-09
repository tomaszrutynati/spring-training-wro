package pl.sda.springboottraining.repository.model;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Setter
    private Integer id;
    private String firstName;
    private String lastName;
    private String idNumber;
}
