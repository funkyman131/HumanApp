package pl.sda.humanresource.repository;

import pl.sda.humanresource.api.model.WorkerSearchParams;

import java.util.List;

public interface CustomWorkerRepository {

    List<WorkerEntity> findWithSearchParams(WorkerSearchParams searchParams);
}
