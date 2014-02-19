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

public class VerCentros extends Activity 
{
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
			 	 	 
			final TextView lblCodigo=(TextView)item.findViewById(R.id.codigo);
			final TextView lbltipo = (TextView)item.findViewById(R.id.tipo);
			final TextView lblnombre = (TextView)item.findViewById(R.id.nombre);
			final TextView lbltelefono=(TextView)item.findViewById(R.id.telefono);
			final TextView lblplazas = (TextView)item.findViewById(R.id.plazas);
			final TextView lblDireccion = (TextView)item.findViewById(R.id.direccion);
			
			lblCodigo.setText(String.valueOf(datos[position].getCodCentro()));
			lbltipo.setText(datos[position].getTipoCentro());
			lblnombre.setText(datos[position].getNomCentro());
			lblDireccion.setText(datos[position].getDireccionCentro());
			lbltelefono.setText(datos[position].getTelefono());
			lblplazas.setText(String.valueOf(datos[position].getPlazas()));
			
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
			
			String[] campos = new String[] {"cod_centro","tipo_centro","nombre","direccion","telefono","num_plazas"};
			
			Sql base=new Sql(this,"db",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			Cursor rs=db.query("centros", campos, null,null,null,null,null);
			
			datos=new Centros[rs.getCount()+1];//Devuelve el número de filas + 1 
			datos[0]= new Centros(0,"a","","","",0);
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		int cod=rs.getInt(0);
	                		String tip=rs.getString(1);
	                        String nom=rs.getString(2);
	                        String dir=rs.getString(3);
	                		String tel=rs.getString(4);
	                        int plaz=rs.getInt(5);
	                        datos[i]=new Centros(cod,tip,nom,dir,tel,plaz);
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
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
			{
	
					
				if(arg2!=0)
				{
					Intent i=new Intent(VerCentros.this,CambiarCentros.class);
					Bundle b=new Bundle();
					String cod=String.valueOf(datos[arg2].getCodCentro());
					String tipo=datos[arg2].getTipoCentro();
					String nombre=datos[arg2].getNomCentro();;
					String dir=datos[arg2].getDireccionCentro();
					String telf=datos[arg2].getTelefono();
					String plazas=String.valueOf(datos[arg2].getPlazas());
					b.putString("codigo",cod);
					b.putString("tipo", tipo);
					b.putString("nombre", nombre);
					b.putString("direccion", dir);
					b.putString("telefono", telf);
					b.putString("plazas", plazas);
					i.putExtras(b);
					startActivity(i);
					finish();
				}	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		inserta.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent=new Intent(VerCentros.this, AddCentro.class);
				startActivity(intent);
				
			}
		});
		
		borra.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent=new Intent(VerCentros.this, EliminarCentros.class);
				startActivity(intent);
			}
		});
		estadistica.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent=new Intent(VerCentros.this, DatosCentros.class);
				startActivity(intent);
				
			}
		});
	}
}

