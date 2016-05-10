package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the slownik_produkt database table.
 * 
 */
@Entity
@Table(name="slownik_produkt")
@NamedQuery(name="SlownikProdukt.findAll", query="SELECT s FROM SlownikProdukt s")
public class SlownikProdukt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_p;

	private String nazwa;

	//bi-directional many-to-one association to ZaleznoscRolaProdukt
	@OneToMany(mappedBy="slownikProdukt")
	private List<ZaleznoscRolaProdukt> zaleznoscRolaProdukts;

	//bi-directional many-to-one association to ZaleznoscSCzynnoscSProdukt
	@OneToMany(mappedBy="slownikProdukt")
	private List<ZaleznoscSCzynnoscSProdukt> zaleznoscSCzynnoscSProdukts;

	public SlownikProdukt() {
	}

	public Integer getID_p() {
		return this.ID_p;
	}

	public void setID_p(Integer ID_p) {
		this.ID_p = ID_p;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ZaleznoscRolaProdukt> getZaleznoscRolaProdukts() {
		return this.zaleznoscRolaProdukts;
	}

	public void setZaleznoscRolaProdukts(List<ZaleznoscRolaProdukt> zaleznoscRolaProdukts) {
		this.zaleznoscRolaProdukts = zaleznoscRolaProdukts;
	}

	public ZaleznoscRolaProdukt addZaleznoscRolaProdukt(ZaleznoscRolaProdukt zaleznoscRolaProdukt) {
		getZaleznoscRolaProdukts().add(zaleznoscRolaProdukt);
		zaleznoscRolaProdukt.setSlownikProdukt(this);

		return zaleznoscRolaProdukt;
	}

	public ZaleznoscRolaProdukt removeZaleznoscRolaProdukt(ZaleznoscRolaProdukt zaleznoscRolaProdukt) {
		getZaleznoscRolaProdukts().remove(zaleznoscRolaProdukt);
		zaleznoscRolaProdukt.setSlownikProdukt(null);

		return zaleznoscRolaProdukt;
	}

	public List<ZaleznoscSCzynnoscSProdukt> getZaleznoscSCzynnoscSProdukts() {
		return this.zaleznoscSCzynnoscSProdukts;
	}

	public void setZaleznoscSCzynnoscSProdukts(List<ZaleznoscSCzynnoscSProdukt> zaleznoscSCzynnoscSProdukts) {
		this.zaleznoscSCzynnoscSProdukts = zaleznoscSCzynnoscSProdukts;
	}

	public ZaleznoscSCzynnoscSProdukt addZaleznoscSCzynnoscSProdukt(ZaleznoscSCzynnoscSProdukt zaleznoscSCzynnoscSProdukt) {
		getZaleznoscSCzynnoscSProdukts().add(zaleznoscSCzynnoscSProdukt);
		zaleznoscSCzynnoscSProdukt.setSlownikProdukt(this);

		return zaleznoscSCzynnoscSProdukt;
	}

	public ZaleznoscSCzynnoscSProdukt removeZaleznoscSCzynnoscSProdukt(ZaleznoscSCzynnoscSProdukt zaleznoscSCzynnoscSProdukt) {
		getZaleznoscSCzynnoscSProdukts().remove(zaleznoscSCzynnoscSProdukt);
		zaleznoscSCzynnoscSProdukt.setSlownikProdukt(null);

		return zaleznoscSCzynnoscSProdukt;
	}

}