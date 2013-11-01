package com.example.david;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;



public class radio extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.radio);
		final RadioButton r1=(RadioButton)findViewById(R.id.baloncesto);
		final RadioButton r2=(RadioButton)findViewById(R.id.futbol);
		final RadioButton r3=(RadioButton)findViewById(R.id.nadar);
		final TextView txt=(TextView)findViewById(R.id.radiotxt);
		final RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
		
		/*View miView=new View(radio.this);
		 boolean checked = ((RadioButton) miView).isChecked();
		    
		    // Check which radio button was clicked
		    switch(miView.getId()) {
		        case R.id.baloncesto:
		            if (checked)
		                txt.setText(r1.getText());
		            break;
		        case R.id.futbol:
		            if (checked)
		            	txt.setText(r2.getText());
		            break;
		        case R.id.nadar:
		            if (checked)
		            	txt.setText(r3.getText());
		            break;
		    }*/
		r1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(r1.isChecked())
					txt.setText("Has seleccionado: "+r1.getText());
				
			}
			
		});
		
		r2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(r2.isChecked())
					txt.setText("Has seleccionado: "+r2.getText());
				
			}
			
		});
		
		r3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(r3.isChecked())
					txt.setText("Has seleccionado: "+r3.getText());
				
			}
			
		});

	}
}
	
