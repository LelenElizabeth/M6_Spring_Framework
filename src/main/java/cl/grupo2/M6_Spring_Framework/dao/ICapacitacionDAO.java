package cl.grupo2.M6_Spring_Framework.dao;

import java.util.ArrayList;

import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;

public interface ICapacitacionDAO {
	
public ArrayList<Capacitacion> obtenerCapacitaciones();
public boolean crearCapacitacion(Capacitacion cap);
public Capacitacion obtenerCapacitacion(int id);
public void actualizar(Capacitacion cap);
public void eliminar(int id);

}
