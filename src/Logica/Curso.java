//Desarrolle una aplicación que almacene en un archivo serializable un conjunto de cursos. Cada curso debe tener un id, nombre y creditos
//
//Desarrolle un menu que permita:
//
//Agregar Curso
//Consultar Cursos
//Actualizar un curso
//Alamacenar cursos en un archivo serializable
//Cargar cursos de un archivo serializable
//Entregue la URL del repositorio donde está su solución


package Logica;

import Persistencia.ArchivoSerializable;
import java.util.HashMap;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Curso {
	private HashMap<Integer, Curso>cursos;
	private int id;
	private String nombre;
	private int creditos;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public HashMap<Integer, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(HashMap<Integer, Curso> cursos) {
		this.cursos = cursos;
	}
	
	

	public Curso(int id,String nombre, int creditos) {
		this.cursos = new HashMap<Integer, Curso>();
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	
	@Override
	public String toString() {
		return this.id + "\t" + this.nombre + "\t" + this.creditos;
	}

	public void cargar() throws Exception {
	    HashMap<Integer, String> lineasCursos = ArchivoSerializable.cargar("Cursos.mio");
	    
	    for (String linea : lineasCursos.values()) {
	        String[] partes = linea.split(";");
	        
	        int id = Integer.parseInt(partes[0]);
	        String nombre = partes[1];
	        int creditos = Integer.parseInt(partes[2]);
	        
	        this.cursos.agregarCurso(id, nombre, creditos);
	    }
	}


	public void almacenar() throws FileNotFoundException, IOException {
		HashMap<Integer, String> lineasCursos = new HashMap<>();
		for(Integer id : this.cursos.keySet()) {
			Curso curso = this.cursos.get(id);
			lineasCursos.put(id, curso.getId() + ";" + curso.getNombre() + ";" + curso.getCreditos() );
		}
		ArchivoSerializable.almacenar("Cursos.mio", lineasCursos);
	}
	


	public void agregarCurso(int id, String nombre, int creditos) throws Exception {
		if(this.cursos.containsKey(id)) {
			throw new Exception ("Curso repetido");			
		}else {
			Curso curso = new Curso(creditos, nombre, creditos);
			this.cursos.put(id, curso);
		}
	}

}
