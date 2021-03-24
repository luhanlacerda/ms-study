package lacerda.luhan.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private Environment env;

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

		logger.info("PORT = " + env.getProperty("local.server.port"));

		Optional<Worker> worker = repository.findById(id);

		if (worker.isPresent())
			return ResponseEntity.ok(worker.get());
		else
			return ResponseEntity.notFound().build();

	}

}
