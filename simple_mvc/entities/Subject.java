package sit202.simple.simple_mvc_lab.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private String id;
    private String title;
    private double credit;
}
