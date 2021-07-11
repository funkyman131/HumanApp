package pl.sda.humanresource.api.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerSearchParams {
    private String firstName;
    private String lastName;
}
