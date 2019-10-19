package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Version;

public class VersionDao {
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
	
	public int agregar(Version objeto) {		
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

	public void actualizar(Version objeto) throws HibernateException {
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
	
	public void eliminar(Version objeto) throws HibernateException {
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
	
	public Version traerVersion(int idVersion) throws HibernateException {
		Version objeto = null;
		try {
			iniciaOperacion();
			objeto = (Version) session.get(Version.class, idVersion);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en VersionABM. 
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	
	public Version traerVersion(String emailCreador, String contrasenia) throws HibernateException {
		Version objeto = null;
		try {
			iniciaOperacion();
			objeto = (Version) session.createQuery("from Version c where c.emailCreador = " +"'" +emailCreador +"'" +"and c.contrasenia = "  +"'" +contrasenia +"'").uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Version> traerVersion() throws HibernateException {
		List<Version> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Version c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	public Version traerVersionYListaClases(int idVersion) throws HibernateException {
		Version objeto = null;
		try {
			iniciaOperacion();
			String hql="from Version c where c.idVersion ="+idVersion;
			objeto=(Version) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaClases());
		}
		finally {
			session.close();
		}
		return objeto;
	}
		
} 
