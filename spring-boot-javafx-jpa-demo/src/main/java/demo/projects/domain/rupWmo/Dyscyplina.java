package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dyscyplina database table.
 * 
 */
@Entity
@NamedQuery(name="Dyscyplina.findAll", query="SELECT d FROM Dyscyplina d")
public class Dyscyplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_d;

	private String nazwa;

	//bi-directional many-to-one association to Rola
	@OneToMany(mappedBy="dyscyplina", fetch = FetchType.EAGER)
	private List<Rola> rolas;

	//bi-directional many-to-one association to ZaleznoscDyscyplinaFaza
	@OneToMany(mappedBy="dyscyplina", fetch = FetchType.EAGER)
	private List<ZaleznoscDyscyplinaFaza> zaleznoscDyscyplinaFazas;

	public Dyscyplina() {
	}

	public Integer getID_d() {
		return this.ID_d;
	}

	public void setID_d(Integer ID_d) {
		this.ID_d = ID_d;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Rola> getRolas() {
		return this.rolas;
	}

	public void setRolas(List<Rola> rolas) {
		this.rolas = rolas;
	}

	public Rola addRola(Rola rola) {
		getRolas().add(rola);
		rola.setDyscyplina(this);

		return rola;
	}

	public Rola removeRola(Rola rola) {
		getRolas().remove(rola);
		rola.setDyscyplina(null);

		return rola;
	}

	public List<ZaleznoscDyscyplinaFaza> getZaleznoscDyscyplinaFazas() {
		return this.zaleznoscDyscyplinaFazas;
	}

	public void setZaleznoscDyscyplinaFazas(List<ZaleznoscDyscyplinaFaza> zaleznoscDyscyplinaFazas) {
		this.zaleznoscDyscyplinaFazas = zaleznoscDyscyplinaFazas;
	}

	public ZaleznoscDyscyplinaFaza addZaleznoscDyscyplinaFaza(ZaleznoscDyscyplinaFaza zaleznoscDyscyplinaFaza) {
		getZaleznoscDyscyplinaFazas().add(zaleznoscDyscyplinaFaza);
		zaleznoscDyscyplinaFaza.setDyscyplina(this);

		return zaleznoscDyscyplinaFaza;
	}

	public ZaleznoscDyscyplinaFaza removeZaleznoscDyscyplinaFaza(ZaleznoscDyscyplinaFaza zaleznoscDyscyplinaFaza) {
		getZaleznoscDyscyplinaFazas().remove(zaleznoscDyscyplinaFaza);
		zaleznoscDyscyplinaFaza.setDyscyplina(null);

		return zaleznoscDyscyplinaFaza;
	}

}