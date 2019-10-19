package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Clase;
import datos.Clase;

public class ClaseDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession(); 
		//Crear una sesion 
		tx = session.beginTransaction(); //Crea una transaccion 
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();                                       
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Clase objeto) {		
		int id = 0;
		try {
			iniciaOperacion(); //Crea la sesion y la transaccion 
			id = Integer.parseInt(session.save(objeto).toString()); //Agregamos el objeto 
			tx.commit(); //Y lo guardo tambien en la base de datos. 
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close(); //Cerramos la sesion 
		}
		return id;
	}

	public void actualizar(Clase objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();	
		}
	}	
	
	public void eliminar(Clase objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto); 
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	
	public Clase traerClase(int idClase) throws HibernateException {
		Clase objeto = new Clase();
		
			iniciaOperacion();
			objeto = (Clase) session.get(Clase.class, idClase);		
		 
			session.close();
		
		return objeto;
	}
	

	
	
	
	public Clase traerClase(String nombre, int idVersion) throws HibernateException {
		Clase objeto = null;
		try {
			iniciaOperacion();
			objeto = (Clase) session.createQuery("from Clase c where c.nombre = " +"'" +nombre +"'" +" and c.idVersion = "   +idVersion ).uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Clase> traerClase() throws HibernateException {
		List<Clase> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Clase c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	public Clase traerClaseYListaAtributos(int idClase) throws HibernateException {
		Clase objeto = null;
		try {
			iniciaOperacion();
			String hql="from Clase c where c.idClase ="+idClase;
			objeto=(Clase) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaAtributos());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
	public Clase traerClaseYListaRelaciones(int idClase) throws HibernateException {
		Clase objeto = null;
		try {
			iniciaOperacion();
			String hql="from Clase c where c.idClase ="+idClase;
			objeto=(Clase) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaRelaciones());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
	public Clase traerClaseYListaMetodos(int idClase) throws HibernateException {
		Clase objeto = null;
		try {
			iniciaOperacion();
			String hql="from Clase c where c.idClase ="+idClase;
			objeto=(Clase) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaMetodos());
		}
		finally {
			session.close();
		}
		return objeto;
	}
		
} 
