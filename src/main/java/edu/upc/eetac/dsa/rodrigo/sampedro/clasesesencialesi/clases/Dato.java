package edu.upc.eetac.dsa.rodrigo.sampedro.clasesesencialesi.clases;

import java.io.Serializable;

public class Dato implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716638L;
	
	int numero;
	String frase;
	char caracter;	
	
	public Dato(int numero, String frase, char caracter) {
		super();
		this.numero = numero;
		this.frase = frase;
		this.caracter = caracter;
	}
	
	public void WriteObjet()
	{
		System.out.println("Este objeto esta formado por:");
		System.out.println("Un Int: " + numero);
		System.out.println("Un String: " + frase);
		System.out.println("Un char: " + caracter);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public char getCaracter() {
		return caracter;
	}
	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}
	

}
