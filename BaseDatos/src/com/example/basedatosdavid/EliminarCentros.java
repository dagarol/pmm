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

public class EliminarCentros extends Activity
{
	
	EditText codigo;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.borracentros);
		codigo=(EditText)findViewById(R.id.e0);
		
	}
	public void borrar(View v)
	{
		Sql base=new Sql(this,"db",null,1);
		SQLiteDatabase db=base.getWritableDatabase();
		String cod=codigo.getText().toString();
		
		int cant=db.delete("centros","cod_centro="+cod,null);
		db.close();
		if (cant==1)
		{
			Toast.makeText(this, "Se borro el centro con el codigo indicado", Toast.LENGTH_SHORT).show();		
		}
		else
		{
			Toast.makeText(this, "No existe ningun codigo con dicho centro", Toast.LENGTH_SHORT).show();	
		}
		
	}
}