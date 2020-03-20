package cr.ac.una.memoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class Preferencias extends AppCompatActivity {


    static Integer bandera;


    public void estadoBandera(View view)
    {
        if(((Switch) findViewById(R.id.switch2)).isChecked())
        {
            bandera=1;
        }else
        {
            bandera=0;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        if (id == R.id.salir) {
            /*Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/

            this.finishAffinity();
        }

        if (id == R.id.juegoAvanzado) {
            Intent intent = new Intent(getApplicationContext(), JuegoAvanzado.class);
            startActivity(intent);
        }

        if (id == R.id.preferencias) {
            Intent intent = new Intent(getApplicationContext(), Preferencias.class);
            startActivity(intent);
        }

        if (id == R.id.juegoSimple) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }




}
