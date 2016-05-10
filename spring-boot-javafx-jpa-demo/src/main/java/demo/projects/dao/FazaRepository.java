package demo.projects.dao;

import demo.projects.domain.rupWmo.Dyscyplina;
import demo.projects.domain.rupWmo.SlownikFaza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2016-04-17.
 */
public interface FazaRepository extends JpaRepository<SlownikFaza,Integer> {
}
