package com.example.david;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaPersona extends Activity {
	
	static class ViewHolder 
	{ 
	TextView lblNombre; 
	TextView lblApellido;
	TextView lblEdad; 
	ImageView lafoto; 
	}
	private Persona[] datos =new Persona[]{
				new Persona("Pepa", "Martinez",29,R.drawable.chica),
				new Persona("Raul", "Serrano",18, R.drawable.chico),
				new Persona("Maria", "Castaño",23, R.drawable.chica2),
				new Persona("Alberto", "Esteso",45, R.drawable.chico2)};
	
	class AdaptadorPersona extends ArrayAdapter<Persona> {
		
		Activity a;
		AdaptadorPersona(Activity b) {
		super(b, R.layout.listin, datos);
		this.a = b;
		}
		
		public View getView(int position,View convertView,ViewGroup parent) {
			ViewHolder holder;
			View item = convertView;
			if(item==null)
			{	
			LayoutInflater inflater = a.getLayoutInflater();	
			item = inflater.inflate(R.layout.listin, null);
			holder=new ViewHolder(); 	 	 
			holder.lblApellido=(TextView)item.findViewById(R.id.apellido);
			holder.lblNombre = (TextView)item.findViewById(R.id.nombre);
			holder.lblEdad = (TextView)item.findViewById(R.id.edad);
			holder.lafoto=(ImageView)item.findViewById(R.id.foto);
			item.setTag(holder);
			}
			else
			{holder=(ViewHolder)item.getTag();}
			holder.lblNombre.setText(datos[position].getNombre());
			holder.lblApellido.setText(datos[position].getApellido());
			holder.lblEdad.setText(Integer.toString(datos[position].getEdad()));
			holder.lafoto.setImageResource(datos[position].getFoto());
			return(item);
			}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        AdaptadorPersona adaptador =new AdaptadorPersona(this);
		final ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
		lstOpciones.setAdapter(adaptador);
		
		lstOpciones.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				
				Intent intent =new Intent(ListaPersona.this, Ejecucion.class);//Creamos el Intent
				
				String nom=((Persona)a.getAdapter().getItem(position)).getNombre();
				String ape =((Persona)a.getAdapter().getItem(position)).getApellido();
				int edad= ((Persona)a.getAdapter().getItem(position)).getEdad();
				int lafoto= ((Persona)a.getAdapter().getItem(position)).getFoto();
				Bundle b = new Bundle();
				b.putString("persona",nom);
				b.putString("apellido", ape);
				b.putInt("edad", edad);
				b.putInt("foto", lafoto);
				//b.putInt("edad", edad);
				
				intent.putExtras(b);
				
                //Iniciamos la nueva actividad
                startActivity(intent);
			}
    });


    }    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
