package pl.sda.humanresource.api;

import pl.sda.humanresource.api.model.NewWork;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.humanresource.service.PositionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/position")
@AllArgsConstructor
public class PositionEndpoint {

    private PositionService positionService;

    @PostMapping
    public void planWork(@Valid @RequestBody NewWork work){
        positionService.planWork(work);
    }

    @DeleteMapping
    public void removePlannedWork(@RequestParam Long workerId){
        positionService.removePlannedWork(workerId);
    }
}
