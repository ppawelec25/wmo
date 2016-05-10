package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zaleznosc_s_czynnosc_s_produkt database table.
 * 
 */
@Entity
@Table(name="zaleznosc_s_czynnosc_s_produkt")
@NamedQuery(name="ZaleznoscSCzynnoscSProdukt.findAll", query="SELECT z FROM ZaleznoscSCzynnoscSProdukt z")
public class ZaleznoscSCzynnoscSProdukt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_c_p;

	//bi-directional many-to-one association to SlownikProdukt
	@ManyToOne
	@JoinColumn(name="ID_p")
	private SlownikProdukt slownikProdukt;

	//bi-directional many-to-one association to SlownikCzynnosc
	@ManyToOne
	@JoinColumn(name="ID_cz")
	private SlownikCzynnosc slownikCzynnosc;

	public ZaleznoscSCzynnoscSProdukt() {
	}

	public Integer getID_z_c_p() {
		return this.ID_z_c_p;
	}

	public void setID_z_c_p(Integer ID_z_c_p) {
		this.ID_z_c_p = ID_z_c_p;
	}

	public SlownikProdukt getSlownikProdukt() {
		return this.slownikProdukt;
	}

	public void setSlownikProdukt(SlownikProdukt slownikProdukt) {
		this.slownikProdukt = slownikProdukt;
	}

	public SlownikCzynnosc getSlownikCzynnosc() {
		return this.slownikCzynnosc;
	}

	public void setSlownikCzynnosc(SlownikCzynnosc slownikCzynnosc) {
		this.slownikCzynnosc = slownikCzynnosc;
	}

}