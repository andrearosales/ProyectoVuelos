package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RUTA_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RUTA_ID_GENERATOR")
	private Integer id;

	private Integer duracion;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="destino")
	private Aeropuerto aeropuerto_destino;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="origen")
	private Aeropuerto aeropuerto_origen;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="rutaBean")
	private List<Vuelo> vuelos;

	public Ruta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Aeropuerto getAeropuerto_destino() {
		return this.aeropuerto_destino;
	}

	public void setAeropuerto_destino(Aeropuerto aeropuerto_destino) {
		this.aeropuerto_destino = aeropuerto_destino;
	}

	public Aeropuerto getAeropuerto_origen() {
		return this.aeropuerto_origen;
	}

	public void setAeropuerto_origen(Aeropuerto aeropuerto_origen) {
		this.aeropuerto_origen = aeropuerto_origen;
	}

	public List<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Vuelo addVuelo(Vuelo vuelo) {
		getVuelos().add(vuelo);
		vuelo.setRutaBean(this);

		return vuelo;
	}

	public Vuelo removeVuelo(Vuelo vuelo) {
		getVuelos().remove(vuelo);
		vuelo.setRutaBean(null);

		return vuelo;
	}

}