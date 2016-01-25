package logica;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Aeropuerto;
import model.Ruta;

/**
 * Session Bean implementation class BeanRuta
 */
@Stateless
public class BeanRuta {

	@PersistenceContext(unitName = "GestionVuelos")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Default constructor.
	 */
	public BeanRuta() {
	}

	public List<Ruta> obtenerRutas() {
		if (entityManager != null) {
			Query query = entityManager.createNamedQuery("Ruta.findAll");
			return query.getResultList();
			/*
			 * TypedQuery<Pasajero> query = entityManager.createQuery(
			 * "SELECT p FROM Pasajero p", Pasajero.class); return
			 * query.getResultList();
			 */
		} else {
			Aeropuerto a1 = new Aeropuerto();
			a1.setCiudad("Bogota");
			a1.setNombre("El dorado");
			Aeropuerto a2 = new Aeropuerto();
			a2.setCiudad("Cartagena");
			a2.setNombre("Rafael Nuñez");
			List<Ruta> list = new ArrayList<Ruta>();
			Ruta r1 = new Ruta();
			r1.setId(1);
			r1.setAeropuerto_origen(a1);
			r1.setAeropuerto_destino(a2);
			r1.setDuracion(100);
			Ruta r2 = new Ruta();
			r2.setId(2);
			r2.setAeropuerto_origen(a2);
			r2.setAeropuerto_destino(a1);
			r2.setDuracion(75);
			list.add(r1);
			list.add(r2);
			return list;
		}
	}

	public void borrarRuta(int id) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Ruta r = entityManager.find(Ruta.class, id);
			entityManager.remove(r);
			entityManager.getTransaction().commit();
		} else
			System.out.println("id " + id);
	}

	public void modificarRuta(String origen_aeropuerto, String origen_ciudad, String destino_aeropuerto,
			String destino_ciudad, int duracion, int id) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Ruta r = entityManager.find(Ruta.class, id);
			if (!origen_aeropuerto.equals(""))
				r.getAeropuerto_origen().setNombre(origen_aeropuerto);
			if (!origen_ciudad.equals(""))
				r.getAeropuerto_origen().setCiudad(origen_ciudad);
			if (!destino_aeropuerto.equals(""))
				r.getAeropuerto_destino().setNombre(destino_aeropuerto);
			if (!destino_ciudad.equals(""))
				r.getAeropuerto_destino().setCiudad(destino_ciudad);
			if (duracion!=0)
				r.setDuracion(duracion);
			entityManager.getTransaction().commit();
		} else
			System.out.println(origen_aeropuerto + " " + origen_ciudad + " " + destino_aeropuerto + " " + destino_ciudad
					+ " " + " " + id);

	}

	public void agregarRuta(String origen_aeropuerto, String origen_ciudad, String destino_aeropuerto,
			String destino_ciudad, int duracion) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();

			Aeropuerto a1 = new Aeropuerto();
			a1.setCiudad(origen_ciudad);
			a1.setNombre(origen_aeropuerto);
			Aeropuerto a2 = new Aeropuerto();
			a2.setCiudad(destino_ciudad);
			a2.setNombre(destino_aeropuerto);

			Ruta r = new Ruta();
			r.setAeropuerto_destino(a2);
			r.setAeropuerto_origen(a1);
			r.setDuracion(duracion);
			entityManager.persist(r);
			entityManager.getTransaction().commit();
		} else
			System.out.println(origen_aeropuerto + " " + origen_ciudad + " " + destino_aeropuerto + " " + destino_ciudad + " " + duracion);
	}

}
