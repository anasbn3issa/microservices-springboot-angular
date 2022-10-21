package tn.esprit.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationService {
	
	@Autowired
	private AssociationRepository repoassos;
	
	public Association addAssociation(Association association) {
		return repoassos.save(association);
	}
	
	public List<Association> retrieveAssociations() {
		return repoassos.findAll();
	}
	
	//Path : http://localhost:8089/AssociationMS/api/associations/retrieve-association/2
	public Association retrieveAssociation(int id) {
		return repoassos.findById(id).orElse(null);
	}
	
	
	public Association updateAssociation (int id,Association newAssociation) {
		if (repoassos.findById(id).isPresent()) {
			Association existingAssociation = repoassos.findById(id).get();
			existingAssociation.setName(newAssociation.getName());
			existingAssociation.setDescription(newAssociation.getDescription());
			
			return repoassos.save(existingAssociation);
		}
		
		else return null;
	}
	
	public String deleteAssociation (int id) {
		if (repoassos.findById(id).isPresent()) {
			repoassos.deleteById(id);
			return "Association supprime";
		}
		
		else return "Association non supprime";
	}

}
