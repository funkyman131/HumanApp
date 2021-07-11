package pl.sda.humanresource.api;

import pl.sda.humanresource.api.model.Errors;
import pl.sda.humanresource.api.model.NewWorker;
import pl.sda.humanresource.api.model.UpdateWorker;
import pl.sda.humanresource.api.model.Worker;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.humanresource.service.WorkerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/worker")
@AllArgsConstructor
public class WorkerEndpoint {

    private WorkerService workerService;

    @GetMapping
    public List<Worker> getAll(){
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public ResponseEntity registerWorker(@Valid @RequestBody NewWorker worker, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errorsMsgs = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            Errors errors = Errors.builder().errors(errorsMsgs).build();

            return ResponseEntity.status(400).body(errors);
        } else {
            workerService.registerWorker(worker);
            return ResponseEntity.status(201).build();
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerWorker(@RequestBody NewWorker worker){

        workerService.registerWorker(worker);
    }

    @PutMapping
    public void updateWorker(@RequestBody UpdateWorker worker){

        workerService.updateWorker(worker);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorker(@PathVariable Long id){

        workerService.deleteWorker(id);
    }
}
