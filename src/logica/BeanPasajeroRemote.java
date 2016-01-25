package logica;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import model.Pasajero;

@Stateless
@Remote
public interface BeanPasajeroRemote {
	
	public List<Pasajero> obtenerPasajeros();
	
	public Pasajero infoPasajero(int documento);

	public void borrarPasajero(int documento);

	public void agregarPasajero(String nombre, String apellido, Date nacimiento, Integer documento,
			String tipoDocumento);

	public void modificarPasajero(String nombre, String apellido, Date nacimiento, Integer documento);
}
