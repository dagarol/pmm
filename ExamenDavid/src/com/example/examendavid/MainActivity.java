package com.example.examendavid;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	String zona;
	String continente;
	int precio;
	int flecha;
	
	private Destino[] datos =new Destino[]{
			new Destino("ZonaA", "Asia y Oceania",30, R.drawable.images),
			new Destino("ZonaB", "America y Africa", 20, R.drawable.images),
			new Destino("ZonaC", "Europa", 10, R.drawable.images)};

class AdaptadorDestino extends ArrayAdapter<Destino> {
	
	Activity a;
	AdaptadorDestino(Activity b) {
	super(b, R.layout.spinner, datos);
	this.a = b;
	}
	
	public View getDropDownView (int position,View convertView,ViewGroup parent) {
	//if(item==null)
		return getView (position, convertView, parent);
	}
	
	public View getView(int position,View convertView,ViewGroup parent) {
	LayoutInflater inflater = a.getLayoutInflater();
		
	View item = inflater.inflate(R.layout.spinner, null);
	 	 	 
	final TextView zona=(TextView)item.findViewById(R.id.texto1);
	final TextView continente = (TextView)item.findViewById(R.id.texto2);
	final TextView precio = (TextView)item.findViewById(R.id.texto3);
	final ImageView flecha=(ImageView)item.findViewById(R.id.imagen);
	
	zona.setText(datos[position].getZona());
	continente.setText(datos[position].getContinente());
	precio.setText(Integer.toString(datos[position].getPrecio()));
	flecha.setImageResource(datos[position].getFlecha());
	
	return(item);
	}
}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorDestino adaptador =new AdaptadorDestino(this);
		final Spinner spinner = (Spinner)findViewById(R.id.spinner);
		final Button boton=(Button)findViewById(R.id.boton);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		
		spinner.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> a,
				android.view.View v, int position, long id) {
				
				zona=((Destino)a.getAdapter().getItem(position)).getZona();
				continente =((Destino)a.getAdapter().getItem(position)).getContinente();
				precio= ((Destino)a.getAdapter().getItem(position)).getPrecio();
				flecha= ((Destino)a.getAdapter().getItem(position)).getFlecha();
				
				}
				
				public void onNothingSelected(AdapterView<?> parent) {
				
				}
				});

		boton.setOnClickListener(new OnClickListener()
		{
    		public void onClick(View v) {
    			
    			
    			final RadioButton normal=(RadioButton)findViewById(R.id.radio1);
    			final RadioButton urgente=(RadioButton)findViewById(R.id.radio2);
    			final CheckBox regalo=(CheckBox)findViewById(R.id.checkbox1);
    			final CheckBox tarjeta=(CheckBox)findViewById(R.id.checkbox2);
    			final EditText editar=(EditText)findViewById(R.id.editar);
    			String pesoString=editar.getText().toString();
    			int peso = Integer.parseInt(pesoString);
    			double precioPeso=1;
    			String tarifa="";
    			String decoracion="";
    			
    			if(peso<6)
    			{
    				precioPeso=peso;
    			}
    			if(peso>=6 && peso<=10)
    			{
    				precioPeso=peso*1.5;
    			}
    			if(peso>=10)
    			{
    				precioPeso=peso*2;
    			}
    			
    			double precioTotal=0;  
    			
    			if(normal.isChecked())
				{
    				precioTotal=precioPeso+precio;
					tarifa="normal";
					
				}
    			
    			if(urgente.isChecked())
    			{
    				precioTotal=precioPeso+precio;
    				precioTotal=precioTotal+precioTotal*0.30;
    				tarifa="urgente";
    			}
    			if(regalo.isChecked() && tarjeta.isChecked())
    			{
    				decoracion="caja regalo y dedicatoria";
    			}	
    			else if(regalo.isChecked())
				{
					decoracion="caja regalo";
				}
    			else if(tarjeta.isChecked())
				{
					decoracion="dedicatoria";
				}
				Intent intent =new Intent(MainActivity.this, Resultado.class);
				Bundle b = new Bundle();
				
				b.putString("zona",zona);
				b.putString("continente", continente);
				b.putString("tarifa",tarifa);
				b.putString("decoracion",decoracion);
				b.putDouble("precioTotal", precioTotal);
				b.putInt("peso", peso);
				
				intent.putExtras(b);
				
		        //Iniciamos la nueva actividad
		        startActivity(intent);
				
				}
				
				
				});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//ONOPTIONSITEMSELECTED sirve para añadir acciones a los items de los menús
	public boolean onOptionsItemSelected(MenuItem item) 
	{ 
		switch (item.getItemId()) 
		{ 
		case R.id.opcion1: 
		Intent intent=new Intent(MainActivity.this, CasaDavid.class);
		startActivity(intent);
		return true; 
		case R.id.opcion2: 
		Intent intent1=new Intent(MainActivity.this, Acerca.class);
		startActivity(intent1);
		return true; 
		default: 
		return super.onOptionsItemSelected(item); 
		}

	}

}




