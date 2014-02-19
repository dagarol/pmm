package com.example.basedatosdavid;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCentro extends Activity
{
	EditText codigo;
	EditText tipo;
	EditText nombre;
	EditText direccion;
	EditText telefono;
	EditText plazas;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertacentro);
		codigo=(EditText)findViewById(R.id.e1);
		tipo=(EditText)findViewById(R.id.e2);
		nombre=(EditText)findViewById(R.id.e3);
		direccion=(EditText)findViewById(R.id.e4);
		telefono=(EditText)findViewById(R.id.e5);
		plazas=(EditText)findViewById(R.id.e6);
		//final Button enviar=(Button)findViewById(R.id.enviar);	
	}
	public void insertar(View v)
	{
		Sql base=new Sql(this,"db",null,1);
			SQLiteDatabase db=base.getWritableDatabase();
			String cod=codigo.getText().toString();
			String tip=tipo.getText().toString();
			String nom=nombre.getText().toString();
			String dir=direccion.getText().toString();
			String tel=telefono.getText().toString();
			String pla=plazas.getText().toString();
		 	ContentValues registro = new ContentValues();
		 	registro.put("cod_centro", cod);
	        registro.put("tipo_centro", tip);//la clave debe llamarse igual que el nombre de la tabla
	        registro.put("nombre", nom);
	        registro.put("direccion", dir);
	        registro.put("telefono", tel);
	        registro.put("num_plazas", pla);
	        db.insert("centros", null, registro);
	        db.close();	
	        codigo.setText("");
	        tipo.setText("");
	        nombre.setText("");
	        direccion.setText("");
	        telefono.setText("");
	        plazas.setText("");
	        Toast.makeText(this, "Nuevo personal registrado" , Toast.LENGTH_SHORT).show();
	}
}