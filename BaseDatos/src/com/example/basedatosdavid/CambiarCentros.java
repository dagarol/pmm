package com.example.basedatosdavid;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CambiarCentros extends Activity 
{

SQLiteDatabase db;
TextView tipo,nombre,telefono,direccion,plazas;
Bundle b;
@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificarcentros);
		Sql cliBDh = new Sql(this, "db", null, 1);
		        db = cliBDh.getWritableDatabase();
		        b=getIntent().getExtras();
		        tipo=(EditText)findViewById(R.id.editTipoCentro);
		        nombre=(EditText)findViewById(R.id.editNombreCentro);
		        telefono=(EditText)findViewById(R.id.editTelfCentro);
		        direccion=(EditText)findViewById(R.id.editDirCentro);
		        plazas=(EditText)findViewById(R.id.editPlazasCentro);
		        Button button=(Button)findViewById(R.id.binseditCentro);
		        setTexto();
		        
		        button.setOnClickListener(new OnClickListener() 
		        {
		
					@Override
					public void onClick(View arg0) 
					{
						db.execSQL("UPDATE centros SET nombre='"+nombre.getText().toString()+"',"
						+ "tipo_centro='"+tipo.getText().toString()+"',"
						+ "telefono='"+telefono.getText().toString()+"',"
						+ "direccion='"+direccion.getText().toString()+"',"
						+ "num_plazas="+Integer.parseInt(plazas.getText().toString())+" "
						+ "WHERE cod_centro="+Integer.parseInt(b.getString("codigo")));
						db.close();
						finish();
					}
		        });
	}

	private void setTexto()
	{
		tipo.setText(b.getString("tipo"));
		nombre.setText(b.getString("nombre"));
		direccion.setText(b.getString("direccion"));
		telefono.setText(b.getString("telefono"));
		plazas.setText(b.getString("plazas"));
	}

}