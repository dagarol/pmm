package com.example.examendavid;

public class Destino 
{
	private String zona;
	private String continente;
	private int precio;
	private int flecha;
	
	
	public Destino(String zona, String continente, int precio, int flecha)
	{
			this.zona = zona;
			this.continente = continente;
			this.precio=precio;
			this.flecha=flecha;
	}
	public String getZona(){
		return zona;
	}

	public String getContinente(){
		return continente;
	}
	public int getPrecio(){
		return precio;
	}

	public int getFlecha(){
		return flecha;
	}
}