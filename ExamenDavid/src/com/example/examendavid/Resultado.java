package com.example.examendavid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends Activity 
{
	double precio;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);
		Bundle bundle=getIntent().getExtras();
		String zona=bundle.getString("zona");
		String continente=bundle.getString("continente");
		precio=bundle.getDouble("precioTotal");
		int peso=bundle.getInt("peso");
		String decoracion=bundle.getString("decoracion");
		String tarifa=bundle.getString("tarifa");
		
		final TextView t1=(TextView)findViewById(R.id.t1);
		final TextView t2=(TextView)findViewById(R.id.t2);
		final TextView t3=(TextView)findViewById(R.id.t3);
		final TextView t4=(TextView)findViewById(R.id.t4);
		final TextView t5=(TextView)findViewById(R.id.t5);
		final Button boton=(Button)findViewById(R.id.boton);
		
		t1.setText(zona+" "+continente);
		t2.setText("Tarifa: "+tarifa);
		String pesofinal=Double.toString(peso);
		t3.setText("Peso: "+pesofinal+"kg");
		t4.setText("Decoracion: Con "+decoracion);
		String preciofinal=Double.toString(precio);
		t5.setText("COSTE FINAL: "+preciofinal);
		boton.setOnClickListener(new OnClickListener()
		{
    		public void onClick(View v) 
    		{
    			Intent intent=new Intent(Resultado.this,Conversion.class);
    			Bundle b=new Bundle();
    			b.putDouble("precio",precio);
    			intent.putExtras(b);
    			startActivity(intent);
    		}
		});
	}
}
