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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class VerProfesores extends Activity 
{
	//Para el simple
	//ArrayList<CentrosIes> centros=new ArrayList<CentrosIes>(); 
	private Profesores[] datos;
	
	class AdaptadorCentro extends ArrayAdapter<Profesores> 
	{
		Activity a;
		AdaptadorCentro(Activity b) 
		{
			super(b, R.layout.listinprofesores, datos);
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
			View item = inflater.inflate(R.layout.listinprofesores, null);
			 	 	 
			final TextView lblCodigo=(TextView)item.findViewById(R.id.codigo);
			final TextView lbldni = (TextView)item.findViewById(R.id.dni);
			final TextView lblapellidos = (TextView)item.findViewById(R.id.apellidos);
			final TextView lblespecialidad = (TextView)item.findViewById(R.id.especialidad);
			
			lblCodigo.setText(String.valueOf(datos[position].getDni()));
			lbldni.setText(String.valueOf(datos[position].getCodCentro()));
			lblapellidos.setText(datos[position].getApellidos());
			lblespecialidad.setText(datos[position].getEspecialidad());
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
		//ArrayList<CentrosIes> centros=new ArrayList<CentrosIes>(); 
		
		try 
		{
			
			String[] campos = new String[] {"cod_centro","dni","apellidos","especialidad"};
			
			Sql base=new Sql(this,"db",null,1);
			
			SQLiteDatabase db=base.getReadableDatabase();
			
			Cursor rs=db.query("profesores", campos, null,null,null,null,null);
			
			datos=new Profesores[rs.getCount()+1];//Devuelve el número de filas + 1 
			datos[0]= new Profesores(0,0,"","");
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		int cod=rs.getInt(0);
	                		int dni=rs.getInt(1);
	                        String ap=rs.getString(2);
	                        String esp=rs.getString(3);
	                        datos[i]=new Profesores(cod,dni,ap,esp);
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

