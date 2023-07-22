package cl.grupo2.M6_Spring_Framework.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo2.M6_Spring_Framework.dao.CapacitacionDAO;
import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;

@Controller
public class CapacitacionesControlador {
	@Autowired
	private CapacitacionDAO cap;
	
	@RequestMapping(value ="/ListarCapacitaciones",method = RequestMethod.GET)
	public ModelAndView listarCapacitaciones() {
		ArrayList<Capacitacion> listaCapacitacion = new ArrayList<>();
		listaCapacitacion = cap.obtenerCapacitaciones();
		
		return new ModelAndView ("listar-capacitaciones","listaCapacitacion",listaCapacitacion);
	}
}
