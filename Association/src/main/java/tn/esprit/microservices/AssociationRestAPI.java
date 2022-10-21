package tn.esprit.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value= "/api/associations")
public class AssociationRestAPI {

	private String chaine ="Testing RestAPI" ;
	@Autowired
	private AssociationService associationService;
	
	//Path : http://localhost:8089/AssociationMS/api/associations/test
	@RequestMapping("/test")
	public String sayHello() {
		System.out.println(chaine);
		return chaine;
	}
	
	//Path : http://localhost:8089/AssociationMS/api/associations/retrieve-all-associations
	@GetMapping("/retrieve-all-associations")
	@ResponseBody
	public List<Association> getAssociations() {
		List<Association> listassociations = associationService.retrieveAssociations();
		return listassociations;
	}
	
	//Path : http://localhost:8089/AssociationMS/api/associations/retrieve-association/:id
	@GetMapping("/retrieve-association/{association-id}")
	@ResponseBody
	public Association getAssociation(@PathVariable("association-id") int assosId) {
		Association association = associationService.retrieveAssociation(assosId);
		return association;
	}

	//Path : http://localhost:8089/AssociationMS/api/associations
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Association> createCandidat(@RequestBody Association association)
	 {
		return new ResponseEntity<>(associationService.addAssociation(association), HttpStatus.OK);
	 }
	
	//Path : http://localhost:8089/AssociationMS/api/associations/:id
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Association> updateAssociation(@PathVariable(value = "id")int id,
													@RequestBody Association candidat)
	 {
		return new ResponseEntity<>(associationService.updateAssociation(id,candidat), HttpStatus.OK);
	 }
	
	//Path : http://localhost:8089/AssociationMS/api/associations/:id
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteAssociation(@PathVariable(value = "id")int id)
	 {
		return new ResponseEntity<>(associationService.deleteAssociation(id), HttpStatus.OK);
	 }
	
}
