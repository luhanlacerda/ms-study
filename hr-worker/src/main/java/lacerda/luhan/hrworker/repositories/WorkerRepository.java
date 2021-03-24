package lacerda.luhan.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lacerda.luhan.hrworker.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
