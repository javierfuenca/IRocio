package com.bussiness.javier.irocio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {
    private EditText txtTemperatura;
    private EditText txtHumedad;
    private Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        txtTemperatura = (EditText)findViewById(R.id.TxtTemperatura);
        txtHumedad=(EditText)findViewById(R.id.TxtHumedad);
        btnCalcular = (Button)findViewById(R.id.BtnCalcular);

        //Implementamos el evento click del boton
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MainActivity.this, Rocio.class);
                //Creamos la informacion a pasar entre actividades
                Bundle b = new Bundle();

                b.putString("TEMPERATURA", txtTemperatura.getText().toString());
                b.putString("HUMEDAD", txtHumedad.getText().toString());

                //Anhadimos la informacion al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
