package demo.projects.domain.rupWmo;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the slownik_czynnosc database table.
 * 
 */
@Entity
@Table(name="slownik_czynnosc")
@NamedQuery(name="SlownikCzynnosc.findAll", query="SELECT s FROM SlownikCzynnosc s")
public class SlownikCzynnosc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_cz;

	private String nazwa;

	//bi-directional many-to-one association to ZaleznoscRolaCzynnosc
	@OneToMany(mappedBy="slownikCzynnosc")
	private List<ZaleznoscRolaCzynnosc> zaleznoscRolaCzynnoscs;

	//bi-directional many-to-one association to ZaleznoscSCzynnoscSProdukt
	@OneToMany(mappedBy="slownikCzynnosc")
	private List<ZaleznoscSCzynnoscSProdukt> zaleznoscSCzynnoscSProdukts;

	public SlownikCzynnosc() {
	}

	public Integer getID_cz() {
		return this.ID_cz;
	}

	public void setID_cz(Integer ID_cz) {
		this.ID_cz = ID_cz;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ZaleznoscRolaCzynnosc> getZaleznoscRolaCzynnoscs() {
		return this.zaleznoscRolaCzynnoscs;
	}

	public void setZaleznoscRolaCzynnoscs(List<ZaleznoscRolaCzynnosc> zaleznoscRolaCzynnoscs) {
		this.zaleznoscRolaCzynnoscs = zaleznoscRolaCzynnoscs;
	}

	public ZaleznoscRolaCzynnosc addZaleznoscRolaCzynnosc(ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc) {
		getZaleznoscRolaCzynnoscs().add(zaleznoscRolaCzynnosc);
		zaleznoscRolaCzynnosc.setSlownikCzynnosc(this);

		return zaleznoscRolaCzynnosc;
	}

	public ZaleznoscRolaCzynnosc removeZaleznoscRolaCzynnosc(ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc) {
		getZaleznoscRolaCzynnoscs().remove(zaleznoscRolaCzynnosc);
		zaleznoscRolaCzynnosc.setSlownikCzynnosc(null);

		return zaleznoscRolaCzynnosc;
	}

	public List<ZaleznoscSCzynnoscSProdukt> getZaleznoscSCzynnoscSProdukts() {
		return this.zaleznoscSCzynnoscSProdukts;
	}

	public void setZaleznoscSCzynnoscSProdukts(List<ZaleznoscSCzynnoscSProdukt> zaleznoscSCzynnoscSProdukts) {
		this.zaleznoscSCzynnoscSProdukts = zaleznoscSCzynnoscSProdukts;
	}

	public ZaleznoscSCzynnoscSProdukt addZaleznoscSCzynnoscSProdukt(ZaleznoscSCzynnoscSProdukt zaleznoscSCzynnoscSProdukt) {
		getZaleznoscSCzynnoscSProdukts().add(zaleznoscSCzynnoscSProdukt);
		zaleznoscSCzynnoscSProdukt.setSlownikCzynnosc(this);

		return zaleznoscSCzynnoscSProdukt;
	}

	public ZaleznoscSCzynnoscSProdukt removeZaleznoscSCzynnoscSProdukt(ZaleznoscSCzynnoscSProdukt zaleznoscSCzynnoscSProdukt) {
		getZaleznoscSCzynnoscSProdukts().remove(zaleznoscSCzynnoscSProdukt);
		zaleznoscSCzynnoscSProdukt.setSlownikCzynnosc(null);

		return zaleznoscSCzynnoscSProdukt;
	}

}