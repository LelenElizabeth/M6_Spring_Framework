package cl.grupo2.M6_Spring_Framework.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo2.M6_Spring_Framework.dao.UsuarioDAO;
import cl.grupo2.M6_Spring_Framework.modelo.TipoUsuario;
import cl.grupo2.M6_Spring_Framework.modelo.Usuario;
import cl.grupo2.M6_Spring_Framework.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {


	@Autowired
	UsuarioServicio uDAOServ;
	
	@RequestMapping(path = "/CrearUsuario", method = RequestMethod.GET)
    public ModelAndView mostrarVista() {
        return new ModelAndView("crear-usuario");
    }
	@RequestMapping(path = "/CrearUsuario", method = RequestMethod.POST)
    public ModelAndView crearUsuario(@RequestParam("nombre") String nombre,
    		@RequestParam("contrasena") String contraseña,
    		@RequestParam("tipo") String tipo) {
		Usuario usu = new Usuario(nombre,contraseña,TipoUsuario.parse(tipo));
		uDAOServ.crearUsuario(usu);
        return new ModelAndView("exito","mensaje","Usuario "+nombre+" creado con éxito.");
    }
	@RequestMapping(path = "/ListadoUsuarios", method = RequestMethod.GET)
    public ModelAndView mostrarLista() {
		ArrayList<Usuario> listaUsuarios = uDAOServ.obtenerUsuarios();
        return new ModelAndView("listado-usuarios","listaUsuarios",listaUsuarios);
    }
}
