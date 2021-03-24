package lacerda.luhan.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lacerda.luhan.hrworker.entities.Worker;
import lacerda.luhan.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Worker> list = repository.findAll();
		if (!list.isEmpty())
			return ResponseEntity.ok(list);
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Worker> worker = repository.findById(id);

		if (worker.isPresent())
			return ResponseEntity.ok(worker);
		else
			return ResponseEntity.notFound().build();

	}

}