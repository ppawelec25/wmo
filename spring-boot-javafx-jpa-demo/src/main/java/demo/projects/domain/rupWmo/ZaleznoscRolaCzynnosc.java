package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zaleznosc_rola_czynnosc database table.
 * 
 */
@Entity
@Table(name="zaleznosc_rola_czynnosc")
@NamedQuery(name="ZaleznoscRolaCzynnosc.findAll", query="SELECT z FROM ZaleznoscRolaCzynnosc z")
public class ZaleznoscRolaCzynnosc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_r_cz;

	//bi-directional many-to-one association to SlownikCzynnosc
	@ManyToOne
	@JoinColumn(name="ID_cz")
	private SlownikCzynnosc slownikCzynnosc;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="ID_r")
	private Rola rola;

	//bi-directional many-to-one association to ZawartoscProjekt
	@OneToMany(mappedBy="zaleznoscRolaCzynnosc")
	private List<ZawartoscProjekt> zawartoscProjekts;

	public ZaleznoscRolaCzynnosc() {
	}

	public Integer getID_z_r_cz() {
		return this.ID_z_r_cz;
	}

	public void setID_z_r_cz(Integer ID_z_r_cz) {
		this.ID_z_r_cz = ID_z_r_cz;
	}

	public SlownikCzynnosc getSlownikCzynnosc() {
		return this.slownikCzynnosc;
	}

	public void setSlownikCzynnosc(SlownikCzynnosc slownikCzynnosc) {
		this.slownikCzynnosc = slownikCzynnosc;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public List<ZawartoscProjekt> getZawartoscProjekts() {
		return this.zawartoscProjekts;
	}

	public void setZawartoscProjekts(List<ZawartoscProjekt> zawartoscProjekts) {
		this.zawartoscProjekts = zawartoscProjekts;
	}

	public ZawartoscProjekt addZawartoscProjekt(ZawartoscProjekt zawartoscProjekt) {
		getZawartoscProjekts().add(zawartoscProjekt);
		zawartoscProjekt.setZaleznoscRolaCzynnosc(this);

		return zawartoscProjekt;
	}

	public ZawartoscProjekt removeZawartoscProjekt(ZawartoscProjekt zawartoscProjekt) {
		getZawartoscProjekts().remove(zawartoscProjekt);
		zawartoscProjekt.setZaleznoscRolaCzynnosc(null);

		return zawartoscProjekt;
	}

}