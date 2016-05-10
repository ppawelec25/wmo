package demo.projects.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.projects.domain.rupWmo.ZaleznoscRolaCzynnosc;
/**
 * Created by Paweł on 2016-04-05.
 */
public interface RolaCzynnoscRepository extends JpaRepository<ZaleznoscRolaCzynnosc,Integer> {
}
