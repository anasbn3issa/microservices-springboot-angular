package tn.esprit.ms.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/locals")
public class LocalRestAPI {

    @Autowired
    private LocalService localService;

    // Path : http://localhost:8094/api/locals
    @GetMapping
    @ResponseBody
    public List<Local> getLocals() {
        List<Local> listlocals = localService.retrieveLocals();
        return listlocals;
    }

    // Path : http://localhost:8094/api/locals/:id
    @GetMapping("/{id}")
    @ResponseBody
    public Local getLocal(@PathVariable("id") int id) {
        Local local = localService.retrieveLocal(id);
        return local;
    }

    // Path : http://localhost:8094/api/locals
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Local> createCandidat(@RequestBody Local local) {
        return new ResponseEntity<>(localService.addLocal(local), HttpStatus.OK);
    }

    // Path : http://localhost:8094/api/locals/update/:id
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Local> updateLocal(@PathVariable(value = "id") int id,
            @RequestBody Local candidat) {
        return new ResponseEntity<>(localService.updateLocal(id, candidat), HttpStatus.OK);
    }

    // Path : http://localhost:8094/api/locals/delete/:id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteLocal(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(localService.deleteLocal(id), HttpStatus.OK);
    }

}
