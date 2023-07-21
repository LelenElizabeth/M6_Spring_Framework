package cl.grupo2.M6_Spring_Framework.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CapacitacionesControlador {
	
	@RequestMapping(path ="/ListarCapacitaciones",method = RequestMethod.GET)
	public ModelAndView listarCapacitaciones() {
		return new ModelAndView ("listar-capacitaciones");
	}
}
