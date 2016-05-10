package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the slownik_faza database table.
 * 
 */
@Entity
@Table(name="slownik_faza")
@NamedQuery(name="SlownikFaza.findAll", query="SELECT s FROM SlownikFaza s")
public class SlownikFaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_f;

	private String nazwa;

	//bi-directional many-to-one association to ZaleznoscDyscyplinaFaza
	@OneToMany(mappedBy="slownikFaza",fetch = FetchType.EAGER)
	private List<ZaleznoscDyscyplinaFaza> zaleznoscDyscyplinaFazas;

	public SlownikFaza() {
	}

	public Integer getID_f() {
		return this.ID_f;
	}

	public void setID_f(Integer ID_f) {
		this.ID_f = ID_f;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ZaleznoscDyscyplinaFaza> getZaleznoscDyscyplinaFazas() {
		return this.zaleznoscDyscyplinaFazas;
	}

	public void setZaleznoscDyscyplinaFazas(List<ZaleznoscDyscyplinaFaza> zaleznoscDyscyplinaFazas) {
		this.zaleznoscDyscyplinaFazas = zaleznoscDyscyplinaFazas;
	}

	public ZaleznoscDyscyplinaFaza addZaleznoscDyscyplinaFaza(ZaleznoscDyscyplinaFaza zaleznoscDyscyplinaFaza) {
		getZaleznoscDyscyplinaFazas().add(zaleznoscDyscyplinaFaza);
		zaleznoscDyscyplinaFaza.setSlownikFaza(this);

		return zaleznoscDyscyplinaFaza;
	}

	public ZaleznoscDyscyplinaFaza removeZaleznoscDyscyplinaFaza(ZaleznoscDyscyplinaFaza zaleznoscDyscyplinaFaza) {
		getZaleznoscDyscyplinaFazas().remove(zaleznoscDyscyplinaFaza);
		zaleznoscDyscyplinaFaza.setSlownikFaza(null);

		return zaleznoscDyscyplinaFaza;
	}

}