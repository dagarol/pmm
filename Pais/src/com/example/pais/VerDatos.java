package com.example.pais;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VerDatos extends Activity 
{
	private BaseDatos conexion;
	private SQLiteDatabase db;
	private String[] datos;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consultarnoticias);
		conexion=new BaseDatos(this,"DBPais",null,1);
		db=conexion.getReadableDatabase();
		leer();
		ListView lista=(ListView)findViewById(R.id.lista);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, datos);
		lista.setAdapter(adapter);
	}
	
	
	public void leer()
	{
		String[] campos = new String[] {"noticia"};
        Cursor c = db.query("pais", campos, null, null, null, null, null);
        datos=new String[c.getCount()];
        System.out.println(c.getCount());
        int i=0;
        if (c.moveToFirst()) {
                do {
                
                		String noticia=c.getString(0);
                        System.out.println(noticia);
                        datos[i]=noticia;
                        i++;
                        
                } while (c.moveToNext());
        }
        db.close();
	}

}