package cloud.quierescomprar.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cloud.quierescomprar.dao.OfertaDao;
import cloud.quierescomprar.dao.OfertaDaoImp;
import cloud.quierescomprar.dao.UsuarioDao;
import cloud.quierescomprar.dao.UsuarioDaoImp;
import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;
import cloud.quierescomprar.model.OfertaVentaId;
import cloud.quierescomprar.model.Usuario;
import cloud.quierescomprar.service.OfertaServiceImp;
import cloud.quierescomprar.service.OfertaVentaServiceImpl;

public class OfertaVentaWebServiceTest {

	@Test
	public void testListaOfertasxUsuario() {
		OfertaVentaServiceImpl servicioOferta= new OfertaVentaServiceImpl();
		Assert.assertEquals(2, servicioOferta.listaOfertaVentaxUsuario().length);
		
		//IMPRESION DE RESULTADOS EN CONSOLA
		String fila="";
		for(int i=0;i<servicioOferta.listaOfertaVentaxUsuario().length;i++){
			fila=servicioOferta.listaOfertaVentaxUsuario()[i];
			String[]celdas=fila.split("#");
			for(int j=0;j<celdas.length;j++){
				System.out.println(celdas[j]);
			}
			
		}
	
	}
	
	
	
	
	//@Test
	//public void testListaOfertasxUsuario() {
		//OfertaVentaServiceImpl servicio= new OfertaVentaServiceImpl();
		//Assert.assertEquals(1, servicio.listaOfertaVentaxUsuario().size());
		
		//IMPRESION DE RESULTADOS EN CONSOLA
		//for(OfertaVenta objOfertaVenta:servicio.listaOfertaVentaxUsuario())
		//{
			
			//System.out.println("USUARIO "+objOfertaVenta.getUsuario().getNombre()+" "+objOfertaVenta.getUsuario().getApePaterno()+" - "+objOfertaVenta.getUsuario().getId().getEmail());
			//System.out.println("EMPRESA "+objOfertaVenta.getOferta().getEmpresa().getRuc()+" - "+objOfertaVenta.getOferta().getEmpresa().getRazonSocial());
			//System.out.println("DESCRIPCION OFERTA "+objOfertaVenta.getOferta().getDescripcion());
			//System.out.println("PRECIO "+objOfertaVenta.getOferta().getPrecio());
			//System.out.println("DESCUENTO "+objOfertaVenta.getOferta().getDescuento());
			//System.out.println("PRECIO OFERTA "+(objOfertaVenta.getOferta().getPrecio().doubleValue()*objOfertaVenta.getOferta().getDescuento().doubleValue()));
			
		//}
	
	//}

	
	
}

