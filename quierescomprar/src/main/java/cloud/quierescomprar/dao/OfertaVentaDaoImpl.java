package cloud.quierescomprar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;
import cloud.quierescomprar.util.HibernateUtil;

public class OfertaVentaDaoImpl implements OfertaVentaDao {

public String[] listaOfertaVentaxUsuario() {
		
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<OfertaVenta> listaOfertasxUsuario=null;
		Query q= null;
		q=sesion.createQuery("from usuario u join fetch u.ofertaventa o where :nomusuario= u.email");
	    String newString = new String();
		//Date newDate=new Date();
		q.setString("nomusuario", newString);
		listaOfertasxUsuario=q.list();
		
		String[] listaOfertasxUsuarioString=new String[listaOfertasxUsuario.size()] ;
		int i=0;
		for(OfertaVenta objOfertaVenta:listaOfertasxUsuario){
			listaOfertasxUsuarioString[i]=
			objOfertaVenta.getUsuario().getNroDocId()+"#"
					+objOfertaVenta.getUsuario().getNombre()+" "+objOfertaVenta.getUsuario().getApePaterno()+ " "+objOfertaVenta.getUsuario().getApeMaterno() +"#"
					+objOfertaVenta.getOferta().getEmpresa()+"#"
					+objOfertaVenta.getOferta().getDescripcion()+"#"
					+objOfertaVenta.getOferta().getDescuento()+"#"
					+(objOfertaVenta.getOferta().getPrecio().doubleValue()-objOfertaVenta.getOferta().getPrecio().doubleValue()*objOfertaVenta.getOferta().getDescuento().doubleValue());
			i++;
			
		}
		
		return listaOfertasxUsuarioString;		
	}

	public int registroOfertaVenta(OfertaVenta objOfertaVenta) {
		Session sesion = HibernateUtil.getSessionFactory();
		
		int retorno=0;
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			sesion.save(objOfertaVenta);
		
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			tx.rollback();
			System.out.println(ex.toString());
			retorno = 0;
		} finally {
			sesion.close();
		}
		
		return retorno;
		
	}

	public List<OfertaVenta> listaOfertasTotalxUsuario() {
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<OfertaVenta> listaOfertas=null;
		Query q= null;
		q=sesion.createQuery("from usuario u join fetch u.ofertaventa o");
	   
		listaOfertas=q.list();
		
		return listaOfertas;
	}	
	
	
}
