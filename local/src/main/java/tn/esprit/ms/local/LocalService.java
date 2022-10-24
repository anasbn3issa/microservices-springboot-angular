package tn.esprit.ms.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {

	@Autowired
	private LocalRepository repository;

	public Local addLocal(Local local) {
		return repository.save(local);
	}

	public List<Local> retrieveLocals() {
		return repository.findAll();
	}

	// Path : http://localhost:8089/LocalMS/api/locals/retrieve-local/2
	public Local retrieveLocal(int id) {
		return repository.findById(id).orElse(null);
	}

	public Local updateLocal(int id, Local newLocal) {
		if (repository.findById(id).isPresent()) {
			Local existingLocal = repository.findById(id).get();
			existingLocal.setName(newLocal.getName());
			existingLocal.setAddress(newLocal.getAddress());
			existingLocal.setStatus(newLocal.getStatus());

			return repository.save(existingLocal);
		}

		else
			return null;
	}

	public String deleteLocal(int id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return "Local supprime";
		}

		else
			return "Local non supprime";
	}

}
