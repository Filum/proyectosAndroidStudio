package cr.ac.una.memoria;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    //variables necesarias
    private List <String> cartas=new ArrayList<>();
    private ImageButton cartaAbierta1;
    private ImageButton cartaAbierta2;
    public Integer cartasEscogidas=0;
    private String deporte1;
    private String deporte2;
    public Integer pareja=0;
    private ImageButton seteo;

    public void reinicioJuego()
    {
        pareja=0;
        cartasEscogidas=0;

        seteo=(ImageButton)findViewById(R.id.tarjeta1);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta2);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta3);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta4);
        seteo.setImageResource(R.drawable.trophy);
        seteo.setClickable(true);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta5);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta6);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta7);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta8);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        seteo=(ImageButton)findViewById(R.id.tarjeta9);
        seteo.setClickable(true);
        seteo.setImageResource(R.drawable.trophy);
        flipIt(seteo);

        Collections.shuffle(cartas);
    }


    public void iniciarJuego()
    {
        cartas.add("futbol");
        cartas.add("futbol");
        cartas.add("basquet");
        cartas.add("basquet");
        cartas.add("baseball");
        //cartas.add("baseball");
        cartas.add("ajedrez");
        cartas.add("ajedrez");
        //cartas.add("ciclismo");
        //cartas.add("ciclismo");
        cartas.add("box");
        cartas.add("box");

        Collections.shuffle(cartas);
    }

    public void abrirCarta(String deporte,ImageButton cartaSeleccionada)
    {

        //setea la carta que abre con la imagen correspondiente
        switch (deporte)
        {
            case "box":
                cartaSeleccionada.setImageResource(R.drawable.boxing);
                break;
            case "ciclismo":
                cartaSeleccionada.setImageResource(R.drawable.bicycle);
                break;
            case "ajedrez":
                cartaSeleccionada.setImageResource(R.drawable.chess);
                break;
            case "futbol":
                cartaSeleccionada.setImageResource(R.drawable.soccer);
                break;
            case "basquet":
                cartaSeleccionada.setImageResource(R.drawable.basketball);
                break;
            case "baseball":
                cartaSeleccionada.setImageResource(R.drawable.baseball);
                break;
        }

        cartasAbiertas(cartaSeleccionada,deporte);
        cartaSeleccionada.setClickable(false);


    }

    public void cartasAbiertas(ImageButton cartaAbierta,String valorDeporte)
    {
        cartasEscogidas=cartasEscogidas+1;//suma una carta abierta


        if(cartasEscogidas==1)
        {
            cartaAbierta1=cartaAbierta;
            deporte1=valorDeporte;
        }else
            if(cartasEscogidas==2) {
                cartaAbierta2 = cartaAbierta;
                deporte2 = valorDeporte;
                validarPareja();
                cartasEscogidas = 0;
            }
    }

    public void delay()
    {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        cartaAbierta1.setImageResource(R.drawable.trophy);
                        cartaAbierta2.setImageResource(R.drawable.trophy);
                        cartaAbierta1.setBackgroundColor(Color.parseColor("#DEDEDE"));
                        cartaAbierta2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                        cartaAbierta1.setClickable(true);
                        cartaAbierta2.setClickable(true);

                    }
                },
                2000
        );
    }


    public void validarPareja()
    {

    if(pareja<4) {

        if (deporte1 == deporte2) {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.good);
            mp.start();
            pareja = pareja + 1;


        } else {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.bad);
            mp.start();
            cartaAbierta1.setBackgroundColor(Color.parseColor("#E55D44"));
            cartaAbierta2.setBackgroundColor(Color.parseColor("#E55D44"));
            delay();
            flipIt(cartaAbierta1);
            flipIt(cartaAbierta2);
        }
    }
        if(pareja==4)
        {

            prueba();
            cartaAbierta2.setClickable(true);
            reinicioJuego();
        }
    }

    private void flipIt(ImageButton b) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(b, "rotationY", 0f, 180);
        flip.setDuration(1000);
        flip.start();
    }


    //metodos on clic para botones
    public void clickCarta1(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta1));
        abrirCarta(cartas.get(0),(ImageButton)findViewById(R.id.tarjeta1));

    }

    public void clickCarta2(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta2));
        abrirCarta(cartas.get(1),(ImageButton)findViewById(R.id.tarjeta2));
    }

    public void clickCarta3(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta3));
        abrirCarta(cartas.get(2),(ImageButton)findViewById(R.id.tarjeta3));
    }

    public void clickCarta4(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta4));
        abrirCarta(cartas.get(3),(ImageButton)findViewById(R.id.tarjeta4));
    }

    public void clickCarta5(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta5));
        abrirCarta(cartas.get(4),(ImageButton)findViewById(R.id.tarjeta5));
    }

    public void clickCarta6(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta6));
        abrirCarta(cartas.get(5),(ImageButton)findViewById(R.id.tarjeta6));
    }

    public void clickCarta7(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta7));
        abrirCarta(cartas.get(6),(ImageButton)findViewById(R.id.tarjeta7));
    }

    public void clickCarta8(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta8));
        abrirCarta(cartas.get(7),(ImageButton)findViewById(R.id.tarjeta8));
    }

    public void clickCarta9(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta9));
        abrirCarta(cartas.get(8),(ImageButton)findViewById(R.id.tarjeta9));
    }

    public void clickCarta10(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta10));
        abrirCarta(cartas.get(9),(ImageButton)findViewById(R.id.tarjeta10));
    }

    public void clickCarta11(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta11));
        abrirCarta(cartas.get(10),(ImageButton)findViewById(R.id.tarjeta11));
    }

    public void clickCarta12(View view)
    {
        flipIt((ImageButton)findViewById(R.id.tarjeta12));
        abrirCarta(cartas.get(11),(ImageButton)findViewById(R.id.tarjeta12));
    }



    public void prueba()
    {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "¡GANASTE EL JUEGO!", Toast.LENGTH_LONG);

        toast1.show();
    }

    public void prueba1()
    {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        ""+pareja, Toast.LENGTH_LONG);

        toast1.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        iniciarJuego();

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
