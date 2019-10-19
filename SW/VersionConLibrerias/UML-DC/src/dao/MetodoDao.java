package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Metodo;

public class MetodoDao {
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
	
	public int agregar(Metodo objeto) {		
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

	public void actualizar(Metodo objeto) throws HibernateException {
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
	
	public void eliminar(Metodo objeto) throws HibernateException {
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
	
	public Metodo traerMetodo(int idMetodo) throws HibernateException {
		Metodo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Metodo) session.get(Metodo.class, idMetodo);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en MetodoABM. 
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	
	public Metodo traerMetodo(String emailCreador, String contrasenia) throws HibernateException {
		Metodo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Metodo) session.createQuery("from Metodo c where c.emailCreador = " +"'" +emailCreador +"'" +"and c.contrasenia = "  +"'" +contrasenia +"'").uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Metodo> traerMetodo() throws HibernateException {
		List<Metodo> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Metodo c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	public Metodo traerMetodoYListaArgumentos(int idMetodo) throws HibernateException {
		Metodo objeto = null;
		try {
			iniciaOperacion();
			String hql="from Metodo c where c.idMetodo ="+idMetodo;
			objeto=(Metodo) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaArgumentos());
		}
		finally {
			session.close();
		}
		return objeto;
	}
		
} 
