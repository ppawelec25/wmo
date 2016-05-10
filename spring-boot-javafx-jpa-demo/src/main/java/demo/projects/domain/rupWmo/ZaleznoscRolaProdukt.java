package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zaleznosc_rola_produkt database table.
 * 
 */
@Entity
@Table(name="zaleznosc_rola_produkt")
@NamedQuery(name="ZaleznoscRolaProdukt.findAll", query="SELECT z FROM ZaleznoscRolaProdukt z")
public class ZaleznoscRolaProdukt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_r_p;

	//bi-directional many-to-one association to SlownikProdukt
	@ManyToOne
	@JoinColumn(name="ID_p")
	private SlownikProdukt slownikProdukt;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="ID_r")
	private Rola rola;

	//bi-directional many-to-one association to ZawartoscProjekt
	@OneToMany(mappedBy="zaleznoscRolaProdukt")
	private List<ZawartoscProjekt> zawartoscProjekts;

	public ZaleznoscRolaProdukt() {
	}

	public Integer getID_z_r_p() {
		return this.ID_z_r_p;
	}

	public void setID_z_r_p(Integer ID_z_r_p) {
		this.ID_z_r_p = ID_z_r_p;
	}

	public SlownikProdukt getSlownikProdukt() {
		return this.slownikProdukt;
	}

	public void setSlownikProdukt(SlownikProdukt slownikProdukt) {
		this.slownikProdukt = slownikProdukt;
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
		zawartoscProjekt.setZaleznoscRolaProdukt(this);

		return zawartoscProjekt;
	}

	public ZawartoscProjekt removeZawartoscProjekt(ZawartoscProjekt zawartoscProjekt) {
		getZawartoscProjekts().remove(zawartoscProjekt);
		zawartoscProjekt.setZaleznoscRolaProdukt(null);

		return zawartoscProjekt;
	}

}