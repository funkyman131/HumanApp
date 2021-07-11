package pl.sda.humanresource.api.model;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewWorker {
    private Long id;
    @NotBlank(message = "First name should be present")
    private String firstName;
    @NotBlank(message = "Last name should be present")
    private String lastName;
    private String position;

}
