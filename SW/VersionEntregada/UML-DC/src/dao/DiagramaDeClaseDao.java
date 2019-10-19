package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.DiagramaDeClase;

public class DiagramaDeClaseDao {
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
	
	public int agregar(DiagramaDeClase objeto) {		
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

	public void actualizar(DiagramaDeClase objeto) throws HibernateException {
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
	
	public void eliminar(DiagramaDeClase objeto) throws HibernateException {
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
	
	public DiagramaDeClase traerDiagramaDeClase(long idDiagramaDeClase) throws HibernateException {
		DiagramaDeClase objeto = null;
		try {
			iniciaOperacion();
			objeto = (DiagramaDeClase) session.get(DiagramaDeClase.class, idDiagramaDeClase);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en DiagramaDeClaseABM. 
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public DiagramaDeClase traerDiagramaDeClase(String emailCreador, String contrasenia) throws HibernateException {
		DiagramaDeClase objeto = null;
		try {
			iniciaOperacion();
			objeto = (DiagramaDeClase) session.createQuery("from DiagramaDeClase c where c.emailCreador = " +"'" +emailCreador +"'" +"and c.contrasenia = "  +"'" +contrasenia +"'").uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */
		} finally {
			session.close(); 
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<DiagramaDeClase> traerDiagramaDeClase() throws HibernateException {
		List<DiagramaDeClase> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from DiagramaDeClase c order by c.idDiagramaDeClase asc c.titulo asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	public DiagramaDeClase traerDiagramaDeClaseYListaVersiones(int idDiagramaDeClase) throws HibernateException {
		DiagramaDeClase objeto = null;
		try {
			iniciaOperacion();
			String hql="from DiagramaDeClase c where c.idDiagramaDeClase ="+idDiagramaDeClase;
			objeto=(DiagramaDeClase) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaVersiones());
		}
		finally {
			session.close();
		}
		return objeto;
	}
		
} 
