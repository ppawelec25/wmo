package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zaleznosc_dyscyplina_faza database table.
 * 
 */
@Entity
@Table(name="zaleznosc_dyscyplina_faza")
@NamedQuery(name="ZaleznoscDyscyplinaFaza.findAll", query="SELECT z FROM ZaleznoscDyscyplinaFaza z")
public class ZaleznoscDyscyplinaFaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_d_f;

	//bi-directional many-to-one association to SlownikFaza
	@ManyToOne
	@JoinColumn(name="ID_f")
	private SlownikFaza slownikFaza;

	//bi-directional many-to-one association to Dyscyplina
	@ManyToOne
	@JoinColumn(name="ID_d")
	private Dyscyplina dyscyplina;

	public ZaleznoscDyscyplinaFaza() {
	}

	public Integer getID_z_d_f() {
		return this.ID_z_d_f;
	}

	public void setID_z_d_f(Integer ID_z_d_f) {
		this.ID_z_d_f = ID_z_d_f;
	}

	public SlownikFaza getSlownikFaza() {
		return this.slownikFaza;
	}

	public void setSlownikFaza(SlownikFaza slownikFaza) {
		this.slownikFaza = slownikFaza;
	}

	public Dyscyplina getDyscyplina() {
		return this.dyscyplina;
	}

	public void setDyscyplina(Dyscyplina dyscyplina) {
		this.dyscyplina = dyscyplina;
	}

}