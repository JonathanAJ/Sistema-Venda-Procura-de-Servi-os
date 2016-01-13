package com.projeto.model;

public class Online {
	
	static int contadorOnline = 0;
	
	public static int getOnline(){
		return contadorOnline;
	}
	
	public static void addOnline(){
		contadorOnline++;
	}
	
	public static void rmOnline(){
		contadorOnline--;
	}
}
