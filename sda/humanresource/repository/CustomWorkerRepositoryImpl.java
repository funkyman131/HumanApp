package pl.sda.humanresource.repository;

import org.springframework.stereotype.Repository;
import pl.sda.humanresource.api.model.WorkerSearchParams;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomWorkerRepositoryImpl implements CustomWorkerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<WorkerEntity> findWithSearchParams(WorkerSearchParams searchParams) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkerEntity> query = criteriaBuilder.createQuery(WorkerEntity.class);
        Root<WorkerEntity> root = query.from(WorkerEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if(searchParams.getFirstName() != null && !searchParams.getFirstName().isEmpty()){
            predicates.add(criteriaBuilder.equal(root.get("firstName"), searchParams.getFirstName()));
        }
        if (searchParams.getLastName() != null && !searchParams.getLastName().isEmpty()){
            predicates.add(criteriaBuilder.equal(root.get("lastName"),searchParams.getLastName()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getResultList();
    }
}
