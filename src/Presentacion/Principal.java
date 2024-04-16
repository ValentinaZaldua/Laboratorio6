package Presentacion;

import Persistencia.ArchivoSerializable;
import Logica.Curso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	private Curso curso;

	public static void main(String[] args) {
		new Principal();
	}

	public Principal() {
		this.curso = new Curso(0, null, 0);
		this.menu();
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			try {
				System.out.println("Seleccionar:");
				System.out.println("0. Salir");
				System.out.println("1. Agregar curso");
				System.out.println("2. Consultar curso");
				System.out.println("3. Actualizar curso");
				System.out.println("4. Almacenar curso en archivo serializable");
				System.out.println("5. Cargar curso desde archivo serializable");
				op = sc.nextInt();
				if(op == 1) {
					this.agregarCurso(sc);				
				}else if(op == 2) {
					this.consultarCurso();
				}else if(op == 3) {
					this.actualizarCurso();
				}else if(op == 4) {
					this.almacenar();
				}else if(op == 5) {
					this.cargar();	
				}
			}catch(Exception e) {
				e.getMessage();
			}
		}while(op!=0);
		sc.close();
	}


	private void cargar() throws Exception {
	this.curso.cargar();	
	}


	private void almacenar() throws FileNotFoundException, IOException {
		this.curso.almacenar();
	}


	private void actualizarCurso() {

	}


	private void consultarCurso () {

	}


	private void agregarCurso(Scanner sc) throws Exception {
		System.out.println("Id del curso: ");
		int id = sc.nextInt();
		System.out.println("Nombre del curso: ");
		String nombre = sc.next();
		System.out.println("Creditos del curso: ");
		int creditos = sc.nextInt();
		this.curso.agregarCurso(id, nombre, creditos);
		

	}
}
