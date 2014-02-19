package com.example.basedatosdavid;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class DatosCentros extends Activity 
{
	
	String apell;
	String esp;
	
	//Para el simple
	//ArrayList<CentrosIes> centros=new ArrayList<CentrosIes>(); 
	private Centros[] datos;
	
	class AdaptadorCentro extends ArrayAdapter<Centros> 
	{
		Activity a;
		AdaptadorCentro(Activity b) 
		{
			super(b, R.layout.listincentros, datos);
			this.a = b;
		}
		public View getDropDownView (int position,View convertView,ViewGroup parent) {
			
			//if(item==null)
			return getView (position, convertView, parent);
			}
		public View getView(int position,View convertView,ViewGroup parent) 
		{
		//if(item==null)	
			LayoutInflater inflater = a.getLayoutInflater();	
			View item = inflater.inflate(R.layout.listincentros, null);
			 	 	 
			final TextView lblcodigo=(TextView)item.findViewById(R.id.codigo);
			final TextView lbltipo = (TextView)item.findViewById(R.id.tipo);
			final TextView lblnombre = (TextView)item.findViewById(R.id.nombre);
			final TextView lbldireccion = (TextView)item.findViewById(R.id.direccion);
			final TextView lbltelefono = (TextView)item.findViewById(R.id.telefono);
			final TextView lblplazas= (TextView)item.findViewById(R.id.plazas);
			
			lblcodigo.setText(String.valueOf(datos[position].getCodCentro()));
			lblplazas.setText(String.valueOf(datos[position].getPlazas()));
			lbltipo.setText(datos[position].getTipoCentro());
			lblnombre.setText(datos[position].getNomCentro());
			lbldireccion.setText(datos[position].getDireccionCentro());
			lbltelefono.setText(datos[position].getTelefono());
			return(item);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estadisticacentros);
		try 
		{
			
			String[] campos = new String[] {"cod_centro","tipo_centro","nombre","direccion","telefono","num_plazas"};
			String[] args=new String[]{"150"};
			Sql base=new Sql(this,"db",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			Cursor rs=db.query("centros", campos, "num_plazas>=?", args, null, null, null);
			
			datos=new Centros[rs.getCount()+1];//Devuelve el número de filas + 1 
			datos[0]= new Centros(0,"tip","nom","dir","tel",0);
			
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		int codigo=rs.getInt(0);
	                		String tipo=rs.getString(1);
	                		String nombre=rs.getString(2);
	                		String dir=rs.getString(3);
	                		String tel=rs.getString(4);
	                		int plaz=rs.getInt(5);
	                        datos[i]=new Centros(codigo,tipo,nombre,dir,tel,plaz);
	                        i++;       
	                }
	                while (rs.moveToNext());
	        }
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		final Spinner spinner=(Spinner)findViewById(R.id.centros);
		AdaptadorCentro adaptador =new AdaptadorCentro(this); 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		
		
		
	}
}
