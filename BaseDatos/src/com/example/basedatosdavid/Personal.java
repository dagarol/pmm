package com.example.basedatosdavid;

public class Personal 
{
	private int codigo;
	private int dni;
	private String apellidos;
	private String funcion;
	private double salario;
	
	public Personal(int codigo, int dni, String apellidos, String funcion,double salario)
	{
		this.codigo=codigo;
		this.dni=dni;
		this.apellidos=apellidos;
		this.funcion=funcion;
		this.salario=salario;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public int getDni() {
		return dni;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public String getFuncion() {
		return funcion;
	}
	
	public double getSalario() {
		return salario;
	}
	
}
