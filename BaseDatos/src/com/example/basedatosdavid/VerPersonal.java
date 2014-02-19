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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class VerPersonal extends Activity 
{
	//Para el simple
	//ArrayList<CentrosIes> centros=new ArrayList<CentrosIes>(); 
	private Personal[] datos;
	
	class AdaptadorCentro extends ArrayAdapter<Personal> 
	{
		Activity a;
		AdaptadorCentro(Activity b) 
		{
			super(b, R.layout.listinpersonal, datos);
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
			View item = inflater.inflate(R.layout.listinpersonal, null);
			 	 	 
			final TextView lbldni=(TextView)item.findViewById(R.id.dni);
			final TextView lblapellidos = (TextView)item.findViewById(R.id.apellidos);
			final TextView lblfuncion = (TextView)item.findViewById(R.id.funcion);
			final TextView lblSalario = (TextView)item.findViewById(R.id.salario);
			final TextView lblcodigo=(TextView)item.findViewById(R.id.codigo);
			lblcodigo.setText(String.valueOf(datos[position].getCodigo()));
			lbldni.setText(String.valueOf(datos[position].getDni()));
			lblapellidos.setText(datos[position].getApellidos());
			lblfuncion.setText(datos[position].getFuncion());
			lblSalario.setText(String.valueOf(datos[position].getSalario()));
			
			
			return(item);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compartido);
		final Button inserta=(Button)findViewById(R.id.insertar);
		final Button borra=(Button)findViewById(R.id.borrar);
		final Button estadistica=(Button)findViewById(R.id.estadistica); 
		
		try 
		{
			
			String[] campos = new String[] {"cod_centro","dni","apellidos","funcion","salario"};
			
			Sql base=new Sql(this,"db",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			Cursor rs=db.query("personal", campos, null,null,null,null,null);
			
			datos=new Personal[rs.getCount()+1];//Devuelve el número de filas + 1 
			datos[0]= new Personal(0,0,"Apellido","funcion",0);
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		int codigo=rs.getInt(0);
	                		int dni=rs.getInt(1);
	                		String apell=rs.getString(2);
	                		String fun=rs.getString(3);
	                		Float sal=rs.getFloat(4);
	                        
	                        datos[i]=new Personal(codigo,dni,apell,fun,sal);
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

