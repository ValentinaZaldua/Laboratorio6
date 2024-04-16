package Presentacion;

import Persistencia.ArchivoSerializable;
import Logica.Curso;
import Logica.Grupo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	private Grupo grupo;
	
	public Principal() {
		this.grupo = new Grupo();
		menu();
	}
	
	public static void main(String[] args) {
		new Principal();
		
	}
	
	private void menu() {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			try {
				System.out.println("Seleccione:");
				System.out.println("0. Salir");
				System.out.println("1. Agregar curso");
				System.out.println("2. Consultar curso");
				System.out.println("3. Actualizar un curso");
				System.out.println("4. Almacenar curso en archivo Serializable");
				System.out.println("5. Cargar curso de un archivo Serializable");
				op = sc.nextInt();
				if(op == 1) {
					this.agregarCurso(sc);				
				}else if(op == 2) {
					this.consultarCurso(sc);
				}else if(op == 3) {
					this.actualizarCurso(sc);
				}else if(op == 4) {
					this.almacenar();
				}else if(op == 5) {
					this.cargar();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}while(op != 0);

		sc.close();

	}


	private void cargar()throws FileNotFoundException, ClassNotFoundException, IOException {
		this.grupo = (Grupo)ArchivoSerializable.cargar("grupo.poo");

	}

	private void almacenar() throws FileNotFoundException, IOException {
		ArchivoSerializable.almacenar("grupo.poo", this.grupo);

		
	}

	private void actualizarCurso(Scanner sc) throws Exception {
		System.out.println("Id:");
		int id = sc.nextInt();
		System.out.println("nombre:");
		String nombre = sc.next();
		System.out.println("creditos:");
		String creditos = sc.next();
		
		this.grupo.actualizar(id,nombre,creditos);
		
	}

	private void consultarCurso(Scanner sc) {
		System.out.println("Digite el id del curso a consultar: ");
		int id = sc.nextInt();
		
			for(Integer idCurso: this.grupo.getCursos().keySet()) {
				System.out.println(this.grupo.getCursos().get(idCurso));
			}

//			System.out.println("El curso no existe ");
		}
		
	

	private void agregarCurso(Scanner sc) throws Exception {
		System.out.println("Id:");
		int id = sc.nextInt();
		System.out.println("nombre:");
		String nombre = sc.next();
		System.out.println("creditos:");
		String creditos = sc.next();
		this.grupo.crearGrupo(id, nombre, creditos);
		
	}

	

	
	
	
}
