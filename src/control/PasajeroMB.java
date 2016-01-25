package control;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import logica.BeanPasajero;
import logica.BeanPasajeroRemote;
import model.Pasajero;

public class PasajeroMB {
	
	@EJB
	private BeanPasajeroRemote facadePasajero;
	
	private Integer documento;
	private String apellido;
	private Date nacimiento;
	private String nombre;
	private String tipoDocumento;

	public PasajeroMB() {
		facadePasajero= new BeanPasajero();
	}
	
	public List<Pasajero> listaPasajeros(){
		return facadePasajero.obtenerPasajeros();
	}
	
	public String mostrarInfo(int pasajero){
		String info="";
		Pasajero p = facadePasajero.infoPasajero(pasajero);
		if(p==null){ //Usado como prueba
			info+="Tipo documento: C.C.";
			info+="\nDocumento: 1019063319";
			info+="\nNombre: Andrea";
			info+="\nApellido: Rosales";
			info+="\nFecha de Nacimiento: 1991-09-15";
			return info;
		}
		info+="Tipo documento: "+p.getTipoDocumento();
		info+="\nDocumento: "+p.getDocumento();
		info+="\nNombre: "+p.getNombre();
		info+="\n";
		return info;
	}
	
	public String agregarPasajero(){
		facadePasajero.agregarPasajero(nombre,apellido,nacimiento,documento,tipoDocumento);
		return "pasajeros.xhtml";
	}
	
	public String borrarPasajero(int documento){
		facadePasajero.borrarPasajero(documento);
		return "pasajeros.xhtml";
	}
	
	public String modificarPasajero(){
		Flash flashS = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashS.setKeepMessages(true);
		int validacion = (int) flashS.get("documento");
		facadePasajero.modificarPasajero(nombre,apellido,nacimiento,validacion);
		return "pasajeros.xhtml";
	}
	
	public String modificarFlash(Integer documento){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("documento", documento);
		return "modificar_Pasajero.xhtml";
	}
	
	public Integer getDocumento() {
		return this.documento;
	}

	public void setDocumento(final Integer documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(final Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
