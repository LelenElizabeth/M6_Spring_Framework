package cl.grupo2.M6_Spring_Framework.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;
import cl.grupo2.M6_Spring_Framework.servicio.CapacitacionServicio;

@Controller
public class CrearCapacitacionControlador {

	@Autowired
	private CapacitacionServicio cap;
	
	@RequestMapping(path = "/CrearCapacitacion", method = RequestMethod.GET)
    public ModelAndView mostrarInicio() {
        return new ModelAndView("crearCapacitacion");
    }
	@RequestMapping(path = "/CrearCapacitacion", method = RequestMethod.POST)
    public ModelAndView crearCapacitacion(@RequestParam("nombre") String nombre, 
    		@RequestParam("detalle") String detalle, 
    		@RequestParam("rutCliente") int rutCliente,
    		@RequestParam("dia") String dia,
    		@RequestParam("hora") String hora,
    		@RequestParam("duracion") String duracion,
    		@RequestParam("lugar") String lugar,
    		@RequestParam("cantidadAsistentes") int cantidadAsistentes) {
		
		Capacitacion capacitacion = new Capacitacion(nombre,detalle,rutCliente,dia,hora,lugar,duracion,cantidadAsistentes);
		cap.crearCapacitacion(capacitacion);
		System.out.println(capacitacion);
        return new ModelAndView("exito", "mensaje", "La Capacitacion se ha agregado correctamente.");
    }
}