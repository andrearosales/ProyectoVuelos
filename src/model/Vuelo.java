package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vuelo database table.
 * 
 */
@Entity
@NamedQuery(name="Vuelo.findAll", query="SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VUELO_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VUELO_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time fin;

	private Time inicio;

	//bi-directional many-to-many association to Pasajero
	@ManyToMany
	@JoinTable(
		name="reserva"
		, joinColumns={
			@JoinColumn(name="vuelo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pasajero")
			}
		)
	private List<Pasajero> pasajeros;

	//bi-directional many-to-one association to Avion
	@ManyToOne
	@JoinColumn(name="avion")
	private Avion avionBean;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="ruta")
	private Ruta rutaBean;

	public Vuelo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getFin() {
		return this.fin;
	}

	public void setFin(Time fin) {
		this.fin = fin;
	}

	public Time getInicio() {
		return this.inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public List<Pasajero> getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Avion getAvionBean() {
		return this.avionBean;
	}

	public void setAvionBean(Avion avionBean) {
		this.avionBean = avionBean;
	}

	public Ruta getRutaBean() {
		return this.rutaBean;
	}

	public void setRutaBean(Ruta rutaBean) {
		this.rutaBean = rutaBean;
	}

}