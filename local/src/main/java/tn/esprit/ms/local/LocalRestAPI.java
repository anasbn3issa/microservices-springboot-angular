package tn.esprit.ms.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locals")
public class LocalRestAPI {
    @Autowired
    LocalRepository localRepository;

    @RequestMapping("/all")
    public Iterable<Local> getAllLocals() {
        return localRepository.findAll();
    }

    @RequestMapping("/add")
    public Local addLocal(@RequestBody Local local) {
        return localRepository.save(local);
    }

    @RequestMapping("/delete/{id}")
    public void deleteLocal(@PathVariable int id) {
        localRepository.deleteById(id);
    }

    @RequestMapping("/update/{id}")
    public Local updateLocal(@PathVariable int id, @RequestBody Local local) {
        local.setId(id);
        return localRepository.save(local);
    }

}
