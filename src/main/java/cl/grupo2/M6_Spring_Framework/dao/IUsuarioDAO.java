package cl.grupo2.M6_Spring_Framework.dao;

import java.util.ArrayList;

import cl.grupo2.M6_Spring_Framework.modelo.Usuario;

public interface IUsuarioDAO {

	public ArrayList<Usuario> obtenerUsuarios();
	public boolean crearUsuario(Usuario usu);
	public Usuario obtenerUsuario(int id);
	public void actualizar(Usuario usu);
	public void eliminar(int id);

}
