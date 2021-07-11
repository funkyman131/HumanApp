package pl.sda.humanresource.service;

import pl.sda.humanresource.api.model.NewWork;
import pl.sda.humanresource.api.model.Position;
import pl.sda.humanresource.exception.WorkerAlreadyHasWorkException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.humanresource.repository.PositionEntity;
import pl.sda.humanresource.repository.WorkerEntity;
import pl.sda.humanresource.repository.WorkerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PositionService {

    private WorkerRepository workerRepository;

    @Transactional
    public Set<Position> planWork(NewWork work){
    if(work == null){
    return new HashSet<>();
    }

    return workerRepository.findById(work.getWorkerId()).map(worker -> {
            if(!worker.getPositions().isEmpty()) {
                    throw new WorkerAlreadyHasWorkException("Worker already has work");
    }
        worker.planWork(work.getWorkType());

        return worker.getPositions().stream()
                .map(ent -> new Position(ent.getPositionType()))
                .collect(Collectors.toSet());

//    public void planWork(NewWork work) {
//        workerRepository.findById(work.getWorkerId()).ifPresent(worker ->{
//            if (!worker.getPositions().isEmpty()){
//                throw new WorkerAlreadyHasWorkException("Worker has already planned work");
//            }
//            worker.planWork(work.getWorkType());
        }).orElseGet(HashSet::new);
    }

    public void removePlannedWork(Long workerId){
        Optional<WorkerEntity> maybeWorker = workerRepository.findById(workerId);

        if(!maybeWorker.isPresent()){
            return;
        }
        WorkerEntity worker = maybeWorker.get();
        boolean hasDoneWork = worker.getPositions().stream().anyMatch(PositionEntity::isDone);

        if (hasDoneWork) {
            throw new WorkerAlreadyHasWorkException("Worker has done work already");
        }
        worker.removeWork();
    }

}
