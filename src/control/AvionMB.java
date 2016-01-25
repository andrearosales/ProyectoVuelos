package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import logica.BeanAvion;

import model.Avion;

public class AvionMB {

	@EJB
	private BeanAvion facadeAvion;

	private Integer id;
	private Integer capacidad;
	private String fabricante;
	private String modelo;
	
	public AvionMB() {
		facadeAvion = new BeanAvion();
	}
	
	public List<Avion> listaAviones(){
		return facadeAvion.obtenerAviones();
	}
	
	public String borrarAvion(int id) {
		facadeAvion.borrarAvion(id);
		return "aviones.xhtml";
	}
	
	public String agregarAvion() {
		facadeAvion.agregarAvion(modelo,fabricante,capacidad);
		return "aviones.xhtml";
	}
	
	public String modificarAvion() {
		Flash flashS = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashS.setKeepMessages(true);
		int validacion = (int) flashS.get("id");
		facadeAvion.modificarRuta(modelo,fabricante,capacidad,validacion);
		return "aviones.xhtml";
	}

	public String modificarFlash(Integer id) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", id);
		return "modificar_Avion.xhtml";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	
}
