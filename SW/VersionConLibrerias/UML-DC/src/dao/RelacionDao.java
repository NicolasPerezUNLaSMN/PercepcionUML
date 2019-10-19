package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Relacion;

public class RelacionDao {
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
	
	public int agregar(Relacion objeto) {		
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

	public void actualizar(Relacion objeto) throws HibernateException {
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
	
	public void eliminar(Relacion objeto) throws HibernateException {
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
	
	public Relacion traerRelacion(int idRelacion) throws HibernateException {
		Relacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Relacion) session.get(Relacion.class, idRelacion);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en RelacionABM. 
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	
	public Relacion traerRelacion(String emailCreador, String contrasenia) throws HibernateException {
		Relacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Relacion) session.createQuery("from Relacion c where c.emailCreador = " +"'" +emailCreador +"'" +"and c.contrasenia = "  +"'" +contrasenia +"'").uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Relacion> traerRelacion() throws HibernateException {
		List<Relacion> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Relacion c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}

		
} 
