package cl.grupo2.M6_Spring_Framework.dao;

import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;

@Service
public class CapacitacionDAO implements ICapacitacionDAO {
	
	
	@Override
	public ArrayList<Capacitacion> obtenerCapacitaciones() {

		ArrayList<Capacitacion> listaCapacitacion = new ArrayList<>();

		listaCapacitacion.add(new Capacitacion(1, "Programación Java", "Clase Magistral", 7729454, "Lunes", "10:30",
				"Centro Cultural Gabriela Mistral", "2 Horas", 60));
		listaCapacitacion.add(new Capacitacion(2, "Uso adecuado de extintores",
				"Aprende a identificar los tipos de incendios y cómo utilizar extintores de manera segura.", 12345678,
				"Lunes", "09:30", "Sala de conferencias A", "2 Horas", 60));
		listaCapacitacion.add(new Capacitacion(3, "Elementos de seguridad en el trabajo",
				"Conoce elementos de protección personal y cómo utilizarlos correctamente.", 8866354, "Martes", "09:00",
				"Salón de capacitaciones B", "1.5 Horas", 45));
		listaCapacitacion.add(new Capacitacion(4, "Charla informativa sobre normativas",
				"Descubre normativas y regulaciones vigentes en seguridad laboral y cómo cumplirlas.", 6635472,
				"Miércoles", "11:00", "Auditorio principal", "1 Hora", 50));
		listaCapacitacion.add(new Capacitacion(5, "Prevención de riesgos en manejo químico",
				"Identifica riesgos y medidas preventivas para manejo de sustancias químicas.", 66289282, "Jueves",
				"15:30", "Auditorio principal", "1.5 Horas", 60));
		listaCapacitacion.add(new Capacitacion(6, "Seguridad en altura y manejo de herramientas",
				"Riesgos en trabajo en altura y uso seguro de herramientas", 8842367, "Viernes", "10:00",
				"Sala de conferencias B", "2 Horas", 60));
		return listaCapacitacion;
	}

	@Override
	public boolean crearCapacitacion(Capacitacion cap) {
		
		System.out.println(cap);
		
		return false;
	}

}
