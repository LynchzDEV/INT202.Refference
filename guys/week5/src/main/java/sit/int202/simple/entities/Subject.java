package sit.int202.simple.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Subject {
    private String id;
    private String title;
    private double credit;
}
