package pl.sda.humanresource.service;

import pl.sda.humanresource.api.model.NewWorker;
import pl.sda.humanresource.api.model.Position;
import pl.sda.humanresource.api.model.UpdateWorker;
import pl.sda.humanresource.api.model.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.humanresource.repository.WorkerEntity;
import pl.sda.humanresource.repository.WorkerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerService {

    private WorkerRepository workerRepository;

    public void registerWorker(NewWorker newWorker){
        WorkerEntity entity = WorkerEntity.builder()
                .firstName(newWorker.getFirstName())
                .lastName(newWorker.getLastName())
                .position(newWorker.getPosition())
                .build();
        workerRepository.save(entity);
    }

    @Transactional
    public void updateWorker(UpdateWorker updateWorker){
        workerRepository.findById(updateWorker.getId())
                .map(work -> work.updateWorker(updateWorker.getFirstName(), updateWorker.getLastName()))
                .orElseThrow(() -> new IllegalStateException("Worker doesn't exist"));
    }

    public Worker getWorker(Long id){
        return workerRepository.findById(id)
                .map(this::mapToWorker)
                .orElseThrow(() -> new IllegalStateException("Worker doesn't exist"));
    }

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll()
                .stream()
                .map(this::mapToWorker)
                .collect(Collectors.toList());
    }

    public void deleteWorker(Long id){
        workerRepository.deleteById(id);
    }

    private Worker mapToWorker(WorkerEntity entity){
        return Worker.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .position(entity.getPosition())
                .plannedWork(entity.getPositions().stream()
                        .map(pos -> new Position(pos.getPositionType()))
                .collect(Collectors.toList()))
                .build();
    }
}
