package com.example.basedatosdavid;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Indice extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);	
		final Button boton1=(Button)findViewById(R.id.boton1);
		final Button boton2=(Button)findViewById(R.id.boton2);
		final Button boton3=(Button)findViewById(R.id.boton3);
		Sql base=new Sql(this,"db",null,1);
		SQLiteDatabase db=base.getReadableDatabase();
		boton1.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent1=new Intent(Indice.this,VerCentros.class);
				startActivity(intent1);
				
			}
		});
		boton2.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent2=new Intent(Indice.this,VerPersonal.class);
				startActivity(intent2);
				
			}
		});
		boton3.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent3=new Intent(Indice.this,VerProfesores.class);
				startActivity(intent3);
			}
		});
	}
	
}
