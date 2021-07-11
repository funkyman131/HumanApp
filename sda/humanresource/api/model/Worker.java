package pl.sda.humanresource.api.model;

import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {

private Long id;
private String firstName;
private String lastName;
private String position;
private List<Position> plannedWork;
}
