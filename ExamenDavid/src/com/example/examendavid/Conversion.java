package com.example.examendavid;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Conversion extends Activity 
{
	TransitionDrawable transicion1;
	TransitionDrawable transicion2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cambio);
		Bundle bundle=getIntent().getExtras();
		double precio=bundle.getDouble("precio");
		int precio2=(int)precio;

		final TextView tv = (TextView)findViewById(R.id.tv);
		
		tv.setText("CAMBIO DE BILLETES"+"\n");
		int vector[]={500, 200, 100, 50, 20, 10, 5, 2, 1};
		for(int i=0; i < vector.length; i++)
		{
			int billete=precio2/vector[i];
			int resto=precio2%vector[i];
			if(billete!=0)
			{
				String texto1=vector[i]+" : "+ billete+"\n";
				tv.append(texto1);
			}

			precio2=resto;

		}
        
        ImageView imagen=(ImageView)findViewById(R.id.i1);
     	TransitionDrawable transicion = (TransitionDrawable) 
    			getResources().getDrawable(R.drawable.transicion);
    	imagen.setImageDrawable(transicion);
    	
    	transicion.startTransition(5000);
    }

	
	}