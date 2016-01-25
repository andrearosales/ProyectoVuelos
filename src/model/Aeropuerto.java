package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aeropuerto database table.
 * 
 */
@Entity
@NamedQuery(name="Aeropuerto.findAll", query="SELECT a FROM Aeropuerto a")
public class Aeropuerto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AEROPUERTO_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AEROPUERTO_ID_GENERATOR")
	private Integer id;

	private String ciudad;

	private String nombre;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="aeropuerto_destino")
	private List<Ruta> destinos;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="aeropuerto_origen")
	private List<Ruta> origenes;

	public Aeropuerto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ruta> getDestinos() {
		return this.destinos;
	}

	public void setDestinos(List<Ruta> destinos) {
		this.destinos = destinos;
	}

	public Ruta addDestino(Ruta destino) {
		getDestinos().add(destino);
		destino.setAeropuerto_destino(this);

		return destino;
	}

	public Ruta removeDestino(Ruta destino) {
		getDestinos().remove(destino);
		destino.setAeropuerto_destino(null);

		return destino;
	}

	public List<Ruta> getOrigenes() {
		return this.origenes;
	}

	public void setOrigenes(List<Ruta> origenes) {
		this.origenes = origenes;
	}

	public Ruta addOrigene(Ruta origene) {
		getOrigenes().add(origene);
		origene.setAeropuerto_origen(this);

		return origene;
	}

	public Ruta removeOrigene(Ruta origene) {
		getOrigenes().remove(origene);
		origene.setAeropuerto_origen(null);

		return origene;
	}

}