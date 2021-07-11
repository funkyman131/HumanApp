package pl.sda.humanresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.humanresource.repository.WorkerEntity;

import java.util.List;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

    Long countAllByLastNameIgnoreCase(String lastName);

    List<WorkerEntity> findAllByFirstNameIn(List<String> names);

//@Repository
//public class WorkerRepository {
//    private Long WORKER_ID = 0L;
//
//    private List<WorkerEntity> workers = new ArrayList<>();
//
//    public List<WorkerEntity> getAll() {
//        return workers;
//    }
//
//    public Optional<WorkerEntity> getById(Long id){
//        return workers.stream().filter(work -> work.getId().equals(id)).findFirst();
//    }
//
//    public void delete(Long id){
//        workers.removeIf(work -> work.getId().equals(id));
//    }
//
//    public void create(WorkerEntity worker) {
//        worker.setId(++WORKER_ID);
//
//        workers.add(worker);
//    }
//
//    public void update(WorkerEntity worker) {
//        delete(worker.getId());
//
//        workers.add(worker);
//    }

}
