package pl.sda.humanresource.api.model;


import pl.sda.humanresource.api.validator.WorkType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@PositionRange
public class NewWork {
    private Long workerId;
    @WorkType
    private String workType;

}
