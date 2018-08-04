package mx.com.ipn.escom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AlumnoService {
	
	private static Map<Integer , Alumno> alumnos= new HashMap<>();
	
	static {
		Alumno axel= new Alumno(2015630563,"Axel","Reyes Amezcua","ISC","axelreyez@gmail.com");
		Alumno alfonso= new Alumno(2015630564,"Alfonso","Venancio Landeros","ISC","venacio2@gmail.com");

		alumnos.put(1,axel);
		alumnos.put(2,alfonso);
	}
	/*
	 * REGRESARÁ LA LISTA DE TODOS LOS CLIENTES...
	 */
	@GET
	public List<Alumno> getAlumnos()
	{
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/**
	 *  GUARDARÁ UN ALUMNO NUEV
	 * @param al
	 */
	@POST
	public void addAlumnos(Alumno al)
	{
		alumnos.put(alumnos.size()+1, al);
	}
	/**
	 * 
	 */
	@DELETE
	@Path("/alumnoId")
	public void deleteAlumno(@PathParam("alumnoId") int id)
	{
		alumnos.remove(id);
	}
}
