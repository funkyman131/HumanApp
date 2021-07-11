package pl.sda.humanresource.repository;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    @OneToMany(mappedBy = "worker") //cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<PositionEntity> positions = new HashSet<>();

    public WorkerEntity updateWorker(String newFirstName, String newLastName){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        return this;
    }

    public void removeWork(){
        this.positions = new HashSet<>();
    }

    public void planWork(String workType){
        positions.add(PositionEntity.builder()
        .positionType(workType)
                .done(false)
                .worker(this)
        .build());
    }

}
