package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ArchivoSerializable {

	public static void almacenar(String nombreArchivo, Object obj) throws FileNotFoundException, IOException  {
		ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
		objetoSalida.writeObject(obj);
		objetoSalida.close();
	}
	
	

}
