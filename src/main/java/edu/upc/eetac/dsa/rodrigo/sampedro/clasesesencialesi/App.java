package edu.upc.eetac.dsa.rodrigo.sampedro.clasesesencialesi;

import edu.upc.eetac.dsa.rodrigo.sampedro.clasesesencialesi.clases.Ficheros;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out
				.println("------------------------------------------------------");
		System.out.println("EX 1: ");
		System.out.println();

		String path = System.getProperty("user.dir")+  "/Resources/";
		// EX 1, 2 ,3
		String Direccion = path + "Numeros.txt";
		Ficheros.LeerficheroPrint(Direccion);

		// EX 4 ejemplos de buffer reader y writer
		String Registro = path + "registro.txt";
		int caracteres = Ficheros.ContarCaracteres(Direccion);
		Ficheros.Escribirfichero(caracteres, "Numeros.txt", Registro, false);

		// EX 5 Ejemplos de buffer bytes
		String imagen = path + "Lena.jpg";
		int bytes = Ficheros.ContarBytes(imagen);
		System.out.println("La imagen " + imagen + " contiene : " + bytes
				+ " bytes.");
		Ficheros.Escribirfichero(bytes, "Lena.jpg", Registro, true);

		// EX 6 Ejemplo de Split
		Ficheros.FuncionEx6(Registro);

		// Ex 7 Ejemplos de Serializable
		Ficheros.Ex7();
	}
}
