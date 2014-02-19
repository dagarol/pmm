package com.example.basedatosdavid;

public class Profesores 
{
	private int codCentro;
	private int dni;
	private String apellidos;
	private String especialidad;
	
	public Profesores(int codCentro, int dni,String apellidos,String especialidad)
	{
		this.codCentro=codCentro;
		this.dni=dni;
		this.apellidos=apellidos;
		this.especialidad=especialidad;
	}
	public int getCodCentro() 
	{
		return codCentro;
	}
	public int getDni() 
	{
		return dni;
	}
	public String getApellidos() 
	{
		return apellidos;
	}
	public String getEspecialidad() 
	{
		return especialidad;
	}
	
	
}
