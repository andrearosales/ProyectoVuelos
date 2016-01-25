package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Pasajero;

/**
 * Session Bean implementation class BeanPasajero
 */
@Stateless
public class BeanPasajero {

	/*
	 * private EntityManagerFactory emf; private EntityManager entityManager;
	 */

	@PersistenceContext(unitName = "GestionVuelos")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		// return emf.createEntityManager();
		return entityManager;
	}

	/**
	 * Default constructor.
	 */
	public BeanPasajero() {
		/*
		 * emf= Persistence.createEntityManagerFactory("GestionVuelos");
		 * entityManager = emf.createEntityManager();
		 */
	}

	public List<Pasajero> obtenerPasajeros() {
		if (entityManager != null) {
			Query query = entityManager.createNamedQuery("Pasajero.findAll");
			return query.getResultList();
			/*
			 * TypedQuery<Pasajero> query = entityManager.createQuery(
			 * "SELECT p FROM Pasajero p", Pasajero.class); return
			 * query.getResultList();
			 */
		} else {
			List<Pasajero> list = new ArrayList<Pasajero>();
			Pasajero p = new Pasajero();
			Pasajero p2 = new Pasajero();
			p.setDocumento(1019063319);
			p2.setDocumento(1019063318);
			p.setTipoDocumento("C.C.");
			p2.setTipoDocumento("C.C.");
			p.setNombre("ANDREA");
			p2.setNombre("CAROLINA");
			p.setApellido("ROSALES");
			p2.setApellido("AFRICANO");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			Date d2 = null;
			try {
				d = sdf.parse("1991-09-15");
				d2 = sdf.parse("1990-08-16");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			p.setNacimiento(d);
			p2.setNacimiento(d2);
			list.add(p);
			list.add(p2);
			return list;
		}
	}

	public void borrarPasajero(int documento) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Pasajero p = entityManager.find(Pasajero.class, documento);
			entityManager.remove(p);
			entityManager.getTransaction().commit();
		}
		else
			System.out.println("documento "+documento);
	}

	public void agregarPasajero(String nombre, String apellido, Date nacimiento, Integer documento,
			String tipoDocumento) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Pasajero p = new Pasajero();
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setNacimiento(nacimiento);
			p.setTipoDocumento(tipoDocumento);
			p.setDocumento(documento);
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		}
		else
			System.out.println(nombre+" "+apellido+" "+tipoDocumento+" "+documento+" "+nacimiento);
		
	}

	public void modificarPasajero(String nombre, String apellido, Date nacimiento, Integer documento) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Pasajero p = entityManager.find(Pasajero.class, documento);
			if(!nombre.equals(""))
				p.setNombre(nombre);
			if(!apellido.equals(""))
				p.setApellido(apellido);
			if(nacimiento!=null)
				p.setNacimiento(nacimiento);
			entityManager.getTransaction().commit();
		}
		else
			System.out.println(nombre+" "+apellido+" "+documento+" "+nacimiento);
		
	}

}
