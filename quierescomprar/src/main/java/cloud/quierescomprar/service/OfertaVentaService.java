package cloud.quierescomprar.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cloud.quierescomprar.model.OfertaVenta;

@WebService
public interface OfertaVentaService {
	@WebResult(name="ofertasxusuario")
	
	public String[] listaOfertaVentaxUsuario();
	
	public int registroOfertaVenta(@WebParam(name="objOfertaVenta") OfertaVenta objOfertaVenta);		
}