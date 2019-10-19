package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Atributo;

public class AtributoDao {
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
	
	public int agregar(Atributo objeto) {		
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

	public void actualizar(Atributo objeto) throws HibernateException {
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
	
	public void eliminar(Atributo objeto) throws HibernateException {
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
	
	public Atributo traerAtributo(int idAtributo) throws HibernateException {
		Atributo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Atributo) session.get(Atributo.class, idAtributo);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en AtributoABM. 
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	
	public Atributo traerAtributo(String emailCreador, String contrasenia) throws HibernateException {
		Atributo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Atributo) session.createQuery("from Atributo c where c.emailCreador = " +"'" +emailCreador +"'" +"and c.contrasenia = "  +"'" +contrasenia +"'").uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Atributo> traerAtributo() throws HibernateException {
		List<Atributo> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Atributo c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	

		
} 
