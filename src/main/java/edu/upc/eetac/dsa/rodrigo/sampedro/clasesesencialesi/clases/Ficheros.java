package edu.upc.eetac.dsa.rodrigo.sampedro.clasesesencialesi.clases;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ficheros {

	public static void FuncionEx6(String Fichero) {
		ArrayList<String> archivo = Leerfichero(Fichero);
		SeleccionarMayor(archivo);
	}

	private static void CheckInt(int num) throws BigNumberException {
		if (num > 1000) {
			throw new BigNumberException(num);
		}
	}

	public static void Ex7() {

		FileOutputStream fos;
		FileInputStream fis;
		ObjectOutputStream out = null;
		ObjectInputStream in;

		try {

			fos = new FileOutputStream("fichero.bin");
			fis = new FileInputStream("fichero.bin");
			out = new ObjectOutputStream(fos);
			in = new ObjectInputStream(fis);

			Dato o1 = new Dato(1, "objeto1", 't');
			Dato o2 = new Dato(2, "objeto2", 'y');

			o1.WriteObjet();
			o2.WriteObjet();

			// Escribir el objeto en el fichero
			out.writeObject(o1);
			out.writeObject(o2);

			// Leer el objeto del fichero (en el mismo orden !!)
			Dato o3 = (Dato) in.readObject();
			Dato o4 = (Dato) in.readObject();
			o3.WriteObjet();
			o4.WriteObjet();

		} catch (Exception e) {
			// Printamos las excepciones que aparezcan
			e.printStackTrace();
		} finally {
			// Cerramos el File
			try {

				// Duda ... por queno me deja cerrarlos.

				if (null != out) {
					out.close();
				}

			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}
		}

	}

	public static void LeerficheroPrint(String Direccion) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// abrimos el fichero
			archivo = new File(Direccion);
			fr = new FileReader(archivo);
			// creamso un buffer para poder leer linea a linea
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					int a = Integer.parseInt(linea);
					CheckInt(a);
					System.out.println("Linea:" + i + " Numero: " + a);
				} catch (BigNumberException e3) {
					e3.printStackTrace();
				}

				i++;
			}
		} catch (Exception e) {
			// Printamos las excepciones que aparezcan
			e.printStackTrace();
		} finally {
			// Cerramos el File
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}
		}
	}

	private static void SeleccionarMayor(ArrayList<String> lista) {
		int i = 0;
		int mayor = 0;
		String[] splitado;
		while (i < lista.size()) {
			splitado = lista.get(i).split("-");
			int test = Integer.parseInt(splitado[1]);
			if (test > mayor)
				mayor = test;

			i++;
		}

		System.out.println("El valor maximo encontrado es: " + mayor);
	}

	public static ArrayList<String> Leerfichero(String direccion) {

		ArrayList<String> lineas = new ArrayList<String>();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// abrimos el fichero
			archivo = new File(direccion);
			fr = new FileReader(archivo);
			// creamso un buffer para poder leer linea a linea
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;

			while ((linea = br.readLine()) != null) {
				lineas.add(linea);

			}
		} catch (Exception e) {
			// Printamos las excepciones que aparezcan
			e.printStackTrace();
		} finally {
			// Cerramos el File
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}
		}

		return (lineas);

	}

	public static int ValormaxReg(String direccion) {
		int valormax = 0;
		List<String> lineas = Leerfichero(direccion);
		// leemos el archivo y calculamos cual es el valor mayor

		for (int i = 0; i < lineas.size(); i++) {
			// Make split
			// lineas[i].
		}

		return (valormax);
	}

	public static int ContarBytes(String direccion) {
		File archivo = null;
		InputStream fr = null;
		BufferedInputStream br = null;
		int count = 0;

		try {
			// abrimos el fichero
			archivo = new File(direccion);
			fr = new FileInputStream(archivo);
			// creamso un buffer para poder leer linea a linea
			br = new BufferedInputStream(fr);

			count = br.available();

		} catch (Exception e) {
			// Printamos las excepciones que aparezcan
			e.printStackTrace();
		} finally {
			// Cerramos el File
			try {
				if (null != fr) {
					fr.close();
				}
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}
		}

		return (count);
	}

	public static int ContarCaracteres(String Direccion) {

		FileReader archivo = null;
		BufferedReader br = null;
		String line = null;
		int cont = 0;

		try {

			archivo = new FileReader(Direccion);
			br = new BufferedReader(archivo);

			while ((line = br.readLine()) != null)
				cont += line.length();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != br) {
					br.close();
				}
				if (null != archivo) {
					archivo.close();
				}
			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}

		}

		return (cont);
	}

	public static void Escribirfichero(int caracteres, String nombre,
			String log, boolean reescribir) {
		FileWriter archivo = null;
		BufferedWriter bw = null;

		try {

			archivo = new FileWriter(log, reescribir);
			bw = new BufferedWriter(archivo);

			Date dt = new Date();
			SimpleDateFormat format = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss");
			if (reescribir)
				bw.write("\n");

			bw.write(format.format(dt) + "-" + caracteres + "-" + nombre);
			System.out.println("DEBUG: " + format.format(dt) + " - "
					+ caracteres + " - " + nombre);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != bw) {
					bw.close();
				}
				if (null != archivo) {
					archivo.close();
				}
			} catch (Exception e2) {
				// printamos excepciones en el cierre del fichero
				e2.printStackTrace();
			}
		}

	}
}
