package Logica;

import java.io.Serializable;
import java.util.*;

public class Grupo implements Serializable{
	HashMap<Integer, Curso> cursos;

	public Grupo(HashMap<Integer, Curso> cursos) {
		this.cursos = cursos;
	}
	
	public Grupo() {
		this.cursos = new HashMap<Integer, Curso>();
	}	

	public void setCursos(HashMap<Integer, Curso> cursos) {
		this.cursos = cursos;
	}

	public HashMap<Integer, Curso> getCursos() {
		return cursos;
	}
	
	public void crearGrupo (int id, String nombre, String creditos) throws Exception{
		if(this.cursos.containsKey(id)){
			throw new Exception("grupo repetido");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			this.cursos.put(id, curso);
		}

	}

	public void actualizar(int id, String nombre, String creditos) throws Exception {
		if(!this.cursos.containsKey(id)) {
			throw new Exception("No existe");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			this.cursos.replace(id, curso);
			
		}
	}
	
	


}
