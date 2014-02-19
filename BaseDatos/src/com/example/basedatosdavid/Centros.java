package com.example.basedatosdavid;

public class Centros 
{
	private int codCentro;
	private String tipoCentro;
	private String nombre;
	private String direccion;
	private String telefono;
	private int plazas;
	
	public Centros(int cod, String tipo, String nom,String dir,String tel,int pla)
	{
		codCentro = cod;
		tipoCentro =tipo;
		nombre=nom;
		direccion=dir;
		telefono=tel;
		plazas=pla;	
	}
	
	public int getCodCentro() 
	{
		return codCentro;
	}
	public String getTipoCentro() 
	{
		return tipoCentro;
	}
	public String getNomCentro() 
	{
		return nombre;
	}
	
	public String getDireccionCentro() 
	{
		return direccion;
	}
	public String getTelefono() 
	{
		return telefono;
	}
	public int getPlazas() 
	{
		return plazas;
	}
}
