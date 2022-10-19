package tn.esprit.ms.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardRestAPI {
    @Autowired
    RewardRepository rewardRepository;

    @RequestMapping("/all")
    public Iterable<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    @RequestMapping("/add")
    public Reward addReward(@RequestBody Reward reward) {
        return rewardRepository.save(reward);
    }

    @RequestMapping("/delete/{id}")
    public void deleteReward(@PathVariable int id) {
        rewardRepository.deleteById(id);
    }
    
}
