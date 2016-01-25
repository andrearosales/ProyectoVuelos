package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import logica.BeanRuta;
import model.Ruta;

public class RutaMB {

	@EJB
	private BeanRuta facadeRuta;

	private Integer id;
	private String origen_aeropuerto;
	private String origen_ciudad;
	private String destino_aeropuerto;
	private String destino_ciudad;
	private Integer duracion;

	public RutaMB() {
		facadeRuta = new BeanRuta();
	}

	public List<Ruta> listaRutas() {
		return facadeRuta.obtenerRutas();
	}

	public String borrarRuta(int id) {
		facadeRuta.borrarRuta(id);
		return "rutas.xhtml";
	}

	public String agregarRuta() {
		facadeRuta.agregarRuta(origen_aeropuerto, origen_ciudad, destino_aeropuerto, destino_ciudad, duracion);
		return "rutas.xhtml";
	}

	public String modificarRuta() {
		Flash flashS = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashS.setKeepMessages(true);
		int validacion = (int) flashS.get("id");
		facadeRuta.modificarRuta(origen_aeropuerto, origen_ciudad, destino_aeropuerto, destino_ciudad, duracion,
				validacion);
		return "rutas.xhtml";
	}

	public String modificarFlash(Integer id) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", id);
		return "modificar_Ruta.xhtml";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigen_aeropuerto() {
		return origen_aeropuerto;
	}

	public void setOrigen_aeropuerto(String origen_aeropuerto) {
		this.origen_aeropuerto = origen_aeropuerto;
	}

	public String getOrigen_ciudad() {
		return origen_ciudad;
	}

	public void setOrigen_ciudad(String origen_ciudad) {
		this.origen_ciudad = origen_ciudad;
	}

	public String getDestino_aeropuerto() {
		return destino_aeropuerto;
	}

	public void setDestino_aeropuerto(String destino_aeropuerto) {
		this.destino_aeropuerto = destino_aeropuerto;
	}

	public String getDestino_ciudad() {
		return destino_ciudad;
	}

	public void setDestino_ciudad(String destino_ciudad) {
		this.destino_ciudad = destino_ciudad;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

}
