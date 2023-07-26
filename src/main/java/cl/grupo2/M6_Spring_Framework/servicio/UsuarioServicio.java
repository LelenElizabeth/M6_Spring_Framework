package cl.grupo2.M6_Spring_Framework.servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.M6_Spring_Framework.dao.UsuarioDAO;
import cl.grupo2.M6_Spring_Framework.modelo.Usuario;

@Service
public class UsuarioServicio {
	@Autowired
	UsuarioDAO uDAO;
	
	public ArrayList<Usuario> obtenerUsuarios(){
		return uDAO.obtenerUsuarios();
	}
	public boolean crearUsuario(Usuario usu) {
		return uDAO.crearUsuario(usu);
	}
	public Usuario obtenerUsuario(int id) {
		return uDAO.obtenerUsuario(id);
	}
	public void actualizar(Usuario usu) {
		uDAO.actualizar(usu);
	}
	public void eliminar(int id) {
		uDAO.eliminar(id);
	}
}
