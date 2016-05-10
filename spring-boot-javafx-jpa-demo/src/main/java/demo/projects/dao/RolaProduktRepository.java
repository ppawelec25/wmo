package demo.projects.dao;

import demo.projects.domain.rupWmo.ZaleznoscRolaProdukt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2016-04-05.
 */
public interface RolaProduktRepository extends JpaRepository<ZaleznoscRolaProdukt,Integer> {
}
