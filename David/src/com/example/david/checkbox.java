package com.example.david;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class checkbox extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox);
		find();
		
	}
	
	public void find(){
		final CheckBox c1=(CheckBox)findViewById(R.id.bici);
		final CheckBox c2=(CheckBox)findViewById(R.id.juegos);
		final CheckBox c3=(CheckBox)findViewById(R.id.leer);
		final TextView txt=(TextView)findViewById(R.id.txt);
		final Button boton=(Button)findViewById(R.id.boton);
		
		boton.setOnClickListener(new OnClickListener(){

			String texto=(String) txt.getText();
			@Override
			public void onClick(View v) {
				if(c1.isChecked())
					texto+=c1.getText();
				if(c2.isChecked())
					texto+=c2.getText();
				if(c3.isChecked())
					texto+=c3.getText();
				txt.setText(texto);
				
			}
			
		});
		
		
					
				}
				

	}
