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
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;



public class Curso implements Serializable{
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
	
	
	public Curso(int id, String nombre, int creditos) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public void agregarCurso(int id, String nombre, int creditos) throws Exception {
		if(this.cursos.containsKey(id)) {
			throw new Exception ("Curso repetido");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			this.cursos.put(id, curso);
		}
	}

	
}
