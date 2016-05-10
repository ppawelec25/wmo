package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zaleznosc_pytania_rola database table.
 * 
 */
@Entity
@Table(name="zaleznosc_pytania_rola")
@NamedQuery(name="ZaleznoscPytaniaRola.findAll", query="SELECT z FROM ZaleznoscPytaniaRola z")
public class ZaleznoscPytaniaRola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_z_p_r;

	private int wartosc;

	//bi-directional many-to-one association to Pytania
	@ManyToOne
	@JoinColumn(name="ID_pyt")
	private Pytania pytania;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="ID_r")
	private Rola rola;

	public ZaleznoscPytaniaRola() {
	}

	public Integer getID_z_p_r() {
		return this.ID_z_p_r;
	}

	public void setID_z_p_r(Integer ID_z_p_r) {
		this.ID_z_p_r = ID_z_p_r;
	}

	public int getWartosc() {
		return this.wartosc;
	}

	public void setWartosc(int wartosc) {
		this.wartosc = wartosc;
	}

	public Pytania getPytania() {
		return this.pytania;
	}

	public void setPytania(Pytania pytania) {
		this.pytania = pytania;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

}