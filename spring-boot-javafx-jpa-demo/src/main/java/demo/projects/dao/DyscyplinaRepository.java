package demo.projects.dao;

import demo.projects.domain.rupWmo.Dyscyplina;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2016-04-05.
 */
public interface DyscyplinaRepository extends JpaRepository<Dyscyplina,Integer> {
}
