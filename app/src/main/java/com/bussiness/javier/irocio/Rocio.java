package com.bussiness.javier.irocio;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class Rocio extends ActionBarActivity {
    private TextView txtRocio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocio);

        //Localizar los controles
        txtRocio = (TextView)findViewById(R.id.TxtRocio);

        //Recuperamos la informacion pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        float pepino= (float) (pow((parseDouble(bundle.getString("HUMEDAD"))/100), 0.125)*(112 + 0.9*parseDouble(bundle.getString("TEMPERATURA")))+(0.1*parseDouble(bundle.getString("TEMPERATURA")))-112);

        txtRocio.setText("Punto de rocio: " + pepino);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rocio, menu);
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
