package com.example.examendavid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.view.View;

public class CasaDavid extends Activity { 

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(new Casa (this));
			
		}

		
		public class Casa extends View
		{
			Bitmap imagen;
			public Casa (Context contexto)
			{
				super(contexto);
				imagen=BitmapFactory.decodeResource(getResources(), R.drawable.luna3); 
			}
			
			public void onDraw(Canvas canvas)
			{
				canvas.drawBitmap(imagen, 0, 0, null);
				
				Paint pincel=new Paint();
				pincel.setColor(Color.GRAY);
				pincel.setStrokeWidth(15);
				pincel.setStyle(Style.FILL);
				
				Paint pincelTejado=new Paint();
				pincelTejado.setColor(Color.BLACK);
				pincelTejado.setStrokeWidth(15);
				pincelTejado.setStyle(Style.FILL);
				pincelTejado.setAntiAlias(true);
				
				
				canvas.drawRect(150, 800, 500, 350, pincel);
				
				Path camino=new Path();
				camino.setFillType(FillType.EVEN_ODD);
				
				camino.moveTo(150, 350);
				camino.lineTo(500, 350);
				camino.lineTo(325, 75);
				camino.lineTo(150, 350);
				camino.close();
				canvas.drawPath(camino, pincelTejado);
				
				Paint pincelVentana=new Paint();
				pincelVentana.setColor(Color.BLACK);
				pincelVentana.setStrokeWidth(15);
				pincelVentana.setStyle(Style.STROKE);
				//Primera ventana
				canvas.drawCircle(230,500, 50, pincelVentana);
				
				canvas.drawLine(180, 500, 280, 500, pincelVentana);
				canvas.drawLine(230, 450, 230, 550, pincelVentana);
				//Segunda ventana
				canvas.drawCircle(415,500, 50, pincelVentana);
				
				canvas.drawLine(365, 500, 465, 500, pincelVentana);
				canvas.drawLine(415, 450, 415, 550, pincelVentana);
				
				canvas.drawPath(camino, pincelTejado);
				//Puerta
				canvas.drawRect(300, 800, 350, 650, pincelVentana);
			}
		}

	}
