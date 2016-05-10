package demo.projects.dao;

import demo.projects.domain.rupWmo.Dyscyplina;
import demo.projects.domain.rupWmo.Rola;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2016-04-05.
 */
public interface RolaRepository extends JpaRepository<Rola,Integer> {

}
