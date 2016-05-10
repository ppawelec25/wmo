package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zawartosc_projekt database table.
 * 
 */
@Entity
@Table(name="zawartosc_projekt")
@NamedQuery(name="ZawartoscProjekt.findAll", query="SELECT z FROM ZawartoscProjekt z")
public class ZawartoscProjekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_p;

	//bi-directional many-to-one association to ZaleznoscRolaCzynnosc
	@ManyToOne
	@JoinColumn(name="ID_z_r_cz")
	private ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc;

	//bi-directional many-to-one association to ZaleznoscRolaProdukt
	@ManyToOne
	@JoinColumn(name="ID_z_r_p")
	private ZaleznoscRolaProdukt zaleznoscRolaProdukt;

	//bi-directional many-to-one association to Projekty
	@ManyToOne
	@JoinColumn(name="ID_pr")
	private Projekty projekty;

	public ZawartoscProjekt() {
	}

	public Integer getID_z_p() {
		return this.ID_z_p;
	}

	public void setID_z_p(Integer ID_z_p) {
		this.ID_z_p = ID_z_p;
	}

	public ZaleznoscRolaCzynnosc getZaleznoscRolaCzynnosc() {
		return this.zaleznoscRolaCzynnosc;
	}

	public void setZaleznoscRolaCzynnosc(ZaleznoscRolaCzynnosc zaleznoscRolaCzynnosc) {
		this.zaleznoscRolaCzynnosc = zaleznoscRolaCzynnosc;
	}

	public ZaleznoscRolaProdukt getZaleznoscRolaProdukt() {
		return this.zaleznoscRolaProdukt;
	}

	public void setZaleznoscRolaProdukt(ZaleznoscRolaProdukt zaleznoscRolaProdukt) {
		this.zaleznoscRolaProdukt = zaleznoscRolaProdukt;
	}

	public Projekty getProjekty() {
		return this.projekty;
	}

	public void setProjekty(Projekty projekty) {
		this.projekty = projekty;
	}

}