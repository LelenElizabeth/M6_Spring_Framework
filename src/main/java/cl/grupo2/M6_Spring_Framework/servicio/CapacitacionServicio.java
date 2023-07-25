package cl.grupo2.M6_Spring_Framework.servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.M6_Spring_Framework.dao.CapacitacionDAO;
import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;

@Service
public class CapacitacionServicio {
	
	@Autowired
	CapacitacionDAO cDAO;

	public CapacitacionServicio() {
		super();
	}
	
	public ArrayList<Capacitacion> obtenerCapacitaciones(){
		return cDAO.obtenerCapacitaciones();
	}
	
	public Capacitacion obtenerCapacitacion(int id) {
		return cDAO.obtenerCapacitacion(id);
	}
	
	public void crearCapacitacion(Capacitacion cap) {
		cDAO.crearCapacitacion(cap);
	}
	
	public void actualizar(Capacitacion cap) {
		cDAO.crearCapacitacion(cap);
	}
	
	public void borrarCapacitacion(int id) {
		cDAO.eliminar(id);
	}
}
