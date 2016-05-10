package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_r;

	private String nazwa;

	//bi-directional many-to-one association to Dyscyplina
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_d")
	private Dyscyplina dyscyplina;

	//bi-directional many-to-one association to ZaleznoscPytaniaRola
	@OneToMany(mappedBy="rola", fetch = FetchType.EAGER)
	private List<ZaleznoscPytaniaRola> zaleznoscPytaniaRolas;

	//bi-directional many-to-one association to ZaleznoscRolaCzynnosc
	@OneToMany(mappedBy="rola", fetch = FetchType.EAGER)
	private List<ZaleznoscRolaCzynnosc> zaleznoscRolaCzynnoscs;

	//bi-directional many-to-one association to ZaleznoscRolaProdukt
	@OneToMany(mappedBy="rola", fetch = FetchType.EAGER)
	private List<ZaleznoscRolaProdukt> zaleznoscRolaProdukts;

	public Rola() {
	}

	public Integer getID_r() {
		return this.ID_r;
	}

	public void setID_r(Integer ID_r) {
		this.ID_r = ID_r;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Dyscyplina getDyscyplina() {
		return this.dyscyplina;
	}

	public void setDyscyplina(Dyscyplina dyscyplina) {
		this.dyscyplina = dyscyplina;
	}

	public List<ZaleznoscPytaniaRola> getZaleznoscPytaniaRolas() {
		return this.zaleznoscPytaniaRolas;
	}

	public void setZaleznoscPytaniaRolas(List<ZaleznoscPytaniaRola> zaleznoscPytaniaRolas) {
		this.zaleznoscPytaniaRolas = zaleznoscPytaniaRolas;
	}

	public ZaleznoscPytaniaRola addZaleznoscPytaniaRola(ZaleznoscPytaniaRola zaleznoscPytaniaRola) {
		getZaleznoscPytaniaRolas().add(zaleznoscPytaniaRola);
		zaleznoscPytaniaRola.setRola(this);

		return zaleznoscPytaniaRola;
	}

	public ZaleznoscPytaniaRola removeZaleznoscPytaniaRola(ZaleznoscPytaniaRola zaleznoscPytaniaRola) {
		getZaleznoscPytaniaRolas().remove(zaleznoscPytaniaRola);
		zaleznoscPytaniaRola.setRola(null);

		return zaleznoscPytaniaRola;
	}

	public List<ZaleznoscRolaCzynnosc> getZaleznoscRolaCzynnoscs() {
		return this.zaleznoscRolaCzynnoscs;
	}

	public void setZaleznoscRolaCzynnoscs(List<ZaleznoscRolaCzynnosc> zaleznoscRolaCzynnoscs) {
		this.zaleznoscRolaCzynnoscs = zaleznoscRolaCzynnoscs;
	}

	public ZaleznoscRolaCzynnosc addZaleznoscRolaCzynnosc(ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc) {
		getZaleznoscRolaCzynnoscs().add(zaleznoscRolaCzynnosc);
		zaleznoscRolaCzynnosc.setRola(this);

		return zaleznoscRolaCzynnosc;
	}

	public ZaleznoscRolaCzynnosc removeZaleznoscRolaCzynnosc(ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc) {
		getZaleznoscRolaCzynnoscs().remove(zaleznoscRolaCzynnosc);
		zaleznoscRolaCzynnosc.setRola(null);

		return zaleznoscRolaCzynnosc;
	}

	public List<ZaleznoscRolaProdukt> getZaleznoscRolaProdukts() {
		return this.zaleznoscRolaProdukts;
	}

	public void setZaleznoscRolaProdukts(List<ZaleznoscRolaProdukt> zaleznoscRolaProdukts) {
		this.zaleznoscRolaProdukts = zaleznoscRolaProdukts;
	}

	public ZaleznoscRolaProdukt addZaleznoscRolaProdukt(ZaleznoscRolaProdukt zaleznoscRolaProdukt) {
		getZaleznoscRolaProdukts().add(zaleznoscRolaProdukt);
		zaleznoscRolaProdukt.setRola(this);

		return zaleznoscRolaProdukt;
	}

	public ZaleznoscRolaProdukt removeZaleznoscRolaProdukt(ZaleznoscRolaProdukt zaleznoscRolaProdukt) {
		getZaleznoscRolaProdukts().remove(zaleznoscRolaProdukt);
		zaleznoscRolaProdukt.setRola(null);

		return zaleznoscRolaProdukt;
	}

}