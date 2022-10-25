package tn.esprit.ms.reward;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {


}
    