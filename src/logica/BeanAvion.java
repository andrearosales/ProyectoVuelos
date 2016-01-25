package logica;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Avion;

/**
 * Session Bean implementation class BeanAvion
 */
@Stateless
public class BeanAvion {
	
	@PersistenceContext(unitName = "GestionVuelos")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
    /**
     * Default constructor. 
     */
    public BeanAvion() {
    }

	public List<Avion> obtenerAviones() {
		if (entityManager != null) {
			Query query = entityManager.createNamedQuery("Avion.findAll");
			return query.getResultList();
			/*
			 * TypedQuery<Pasajero> query = entityManager.createQuery(
			 * "SELECT p FROM Pasajero p", Pasajero.class); return
			 * query.getResultList();
			 */
		} else {
			List<Avion> list = new ArrayList<Avion>();
			Avion a1 = new Avion();
			a1.setId(123);
			a1.setModelo("A780");
			a1.setFabricante("Airbus");
			a1.setCapacidad(200);
			Avion a2 = new Avion();
			a2.setId(423);
			a2.setModelo("A490");
			a2.setFabricante("Airbus");
			a2.setCapacidad(100);
			list.add(a1);
			list.add(a2);
			return list;
		}
	}

	public void borrarAvion(int id) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Avion a = entityManager.find(Avion.class, id);
			entityManager.remove(a);
			entityManager.getTransaction().commit();
		} else
			System.out.println("id " + id);
	}

	public void agregarAvion(String modelo, String fabricante, Integer capacidad) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Avion a1 = new Avion();
			a1.setModelo(modelo);
			a1.setFabricante(fabricante);
			a1.setCapacidad(capacidad);
			entityManager.persist(a1);
			entityManager.getTransaction().commit();
		} else
			System.out.println(modelo + " " + fabricante + " " + capacidad);
	}

	public void modificarRuta(String modelo, String fabricante, Integer capacidad, int id) {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			Avion a = entityManager.find(Avion.class, id);
			if (!modelo.equals(""))
				a.setModelo(modelo);
			if (!fabricante.equals(""))
				a.setFabricante(fabricante);
			if (capacidad!=0)
				a.setCapacidad(capacidad);
			entityManager.getTransaction().commit();
		} else
			System.out.println(modelo + " " + fabricante + " " + capacidad + " " + id);
	}

}
