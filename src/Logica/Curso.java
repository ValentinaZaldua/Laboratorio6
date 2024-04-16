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


public class Curso {
	private int id;
	private String nombre;
	private String creditos;
	
	
	public Curso(int id, String nombre, String creditos) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		
	}
	
	public Curso() {
		this.id = 0;
		this.nombre = "";
		this.creditos = "";
		
	}
	


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

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "\t" + this.nombre + "\t" + this.creditos + "\t";
	}
	

}
