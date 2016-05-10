package demo.projects.domain.rupWmo;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pytania database table.
 * 
 */
@Entity
@NamedQuery(name="Pytania.findAll", query="SELECT p FROM Pytania p")
public class Pytania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_pyt;

	private String nazwa;

	//bi-directional many-to-one association to ZaleznoscPytaniaRola
	@OneToMany(mappedBy="pytania")
	private List<ZaleznoscPytaniaRola> zaleznoscPytaniaRolas;

	public Pytania() {
	}

	public Integer getID_pyt() {
		return this.ID_pyt;
	}

	public void setID_pyt(Integer ID_pyt) {
		this.ID_pyt = ID_pyt;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ZaleznoscPytaniaRola> getZaleznoscPytaniaRolas() {
		return this.zaleznoscPytaniaRolas;
	}

	public void setZaleznoscPytaniaRolas(List<ZaleznoscPytaniaRola> zaleznoscPytaniaRolas) {
		this.zaleznoscPytaniaRolas = zaleznoscPytaniaRolas;
	}

	public ZaleznoscPytaniaRola addZaleznoscPytaniaRola(ZaleznoscPytaniaRola zaleznoscPytaniaRola) {
		getZaleznoscPytaniaRolas().add(zaleznoscPytaniaRola);
		zaleznoscPytaniaRola.setPytania(this);

		return zaleznoscPytaniaRola;
	}

	public ZaleznoscPytaniaRola removeZaleznoscPytaniaRola(ZaleznoscPytaniaRola zaleznoscPytaniaRola) {
		getZaleznoscPytaniaRolas().remove(zaleznoscPytaniaRola);
		zaleznoscPytaniaRola.setPytania(null);

		return zaleznoscPytaniaRola;
	}

}