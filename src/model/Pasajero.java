package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pasajero database table.
 * 
 */
@Entity
@NamedQuery(name="Pasajero.findAll", query="SELECT p FROM Pasajero p")
public class Pasajero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PASAJERO_DOCUMENTO_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PASAJERO_DOCUMENTO_GENERATOR")
	private Integer documento;

	private String apellido;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nombre;

	@Column(name="tipo_documento")
	private String tipoDocumento;

	//bi-directional many-to-many association to Vuelo
	@ManyToMany(mappedBy="pasajeros")
	private List<Vuelo> vuelos;

	public Pasajero() {
	}

	public Integer getDocumento() {
		return this.documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}