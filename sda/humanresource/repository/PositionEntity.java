package pl.sda.humanresource.repository;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionType;
    private boolean done;
    @ManyToOne
    private WorkerEntity worker;

}
