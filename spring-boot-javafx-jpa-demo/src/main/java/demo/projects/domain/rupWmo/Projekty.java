package demo.projects.domain.rupWmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projekty database table.
 * 
 */
@Entity
@NamedQuery(name="Projekty.findAll", query="SELECT p FROM Projekty p")
public class Projekty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_pr;

	private String nazwa;

	//bi-directional many-to-one association to ZawartoscProjekt
	@OneToMany(mappedBy="projekty")
	private List<ZawartoscProjekt> zawartoscProjekts;

	public Projekty() {
	}

	public Integer getID_pr() {
		return this.ID_pr;
	}

	public void setID_pr(Integer ID_pr) {
		this.ID_pr = ID_pr;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ZawartoscProjekt> getZawartoscProjekts() {
		return this.zawartoscProjekts;
	}

	public void setZawartoscProjekts(List<ZawartoscProjekt> zawartoscProjekts) {
		this.zawartoscProjekts = zawartoscProjekts;
	}

	public ZawartoscProjekt addZawartoscProjekt(ZawartoscProjekt zawartoscProjekt) {
		getZawartoscProjekts().add(zawartoscProjekt);
		zawartoscProjekt.setProjekty(this);

		return zawartoscProjekt;
	}

	public ZawartoscProjekt removeZawartoscProjekt(ZawartoscProjekt zawartoscProjekt) {
		getZawartoscProjekts().remove(zawartoscProjekt);
		zawartoscProjekt.setProjekty(null);

		return zawartoscProjekt;
	}

}