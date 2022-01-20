package com.asier.aranda.diseointerfaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;

import android.view.MenuItem;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

//IGUAL QUE EL TOAST PERO PARA PODER DESHACER COMO EN GMAIL
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;
    private TextView refrescar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // casting a la vista a la que aplicamos un menu contextual
//        // y la registramos
//        TextView mycontext = (TextView) findViewById(R.id.textTap);
//        registerForContextMenu(mycontext);


        //Referenciamos al WebView con su ID con el contextMENU
        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        //REFERENCIAMOS TAMBIEN AL MISMO ID LA PARTE DE LAS CARAS RANDOM
        miVisorWeb=(WebView) findViewById(R.id.vistaweb);// donde va a ser mostrado
        miVisorWeb.getSettings().setBuiltInZoomControls(true);//HACER ZOOM
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");//cargar URL de internet


        //Encima del WEBVIEW(xml) tenemos lo que hace REFRESH
        //mOnRefreshListerner es un metodo que va a refrescar sacando un toast y demás
        //MIRAR JUSTO ABAJO
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

//-----------------------refrescar--------------------------------------
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener=new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0= Toast.makeText(MainActivity.this,"hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    //----------------------------------MENUCONTEXTUAL---------------------------
    //----------------------------------MENUCONTEXTUAL---------------------------
    //----------------------------------MENUCONTEXTUAL---------------------------

    //AQUI VAMOS A CREAR EL MENUCONTEXTUAL QUE CONTIENE "COPY" && "DOWNLOAD
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    //DEPENDIENDO EN QUE ITEM DEL MENUCONTEXTUAL pulsemos nos saldrá un cartel distinto, es decir COPY" || "DOWNLOAD"
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //COPY al pulsar COPY nos saldrá un mensaje y podremos deshacer
            case R.id.item1:
//                Toast toast = Toast.makeText(this, "Item copied",
//                        Toast.LENGTH_LONG);
//                toast.show();

                final ConstraintLayout mLayout =  findViewById(R.id.myMainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
                return true;

            //DOWLOAD
            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //----------------------------------MENUMAIN---------------------------
    //----------------------------------MENUMAIN---------------------------
    //----------------------------------MENUMAIN---------------------------
//    appbar
    //VAMOS A METER EN LA APP BAR DE NUESTRO ACTIVITY EL ---------MENUMAIN-----
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Dependiendo cual elijamos, es decir, si pulso en la lupa me saca un mensaje
    //si pulso USER me sacará EL ---MENU ALERT DIALOG---QUE CREAREMOS DESPUES
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //aqui almacenamos el id para referenciar
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.settings) {
            Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.user) {
            Toast toast = Toast.makeText(this, "Accediendo a usuario", Toast.LENGTH_LONG);
            toast.show();
            //AQUI REFERENCIAREMOS NUESTRO ALERT DIALOG,es decir, se mostrará al pulsar USER
            showAlertDialogButtonClicked(MainActivity.this);
        }
        if (id == R.id.Bottom_navigation) {
            Intent intent = new Intent(MainActivity.this,MainBN.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    //AQUI CREAMOS EL MENU AL PULSAR USER
    //que dependiendo a cual iconico de dentro pulsemos hará una cosa dentro
    public void showAlertDialogButtonClicked(MainActivity mainActivity){
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);
        builder.setTitle("Achtung!");//TITULO
        builder.setMessage("where do you go?");//MENSAJITO
        builder.setIcon(R.drawable.ic_login);//ICONO
        builder.setCancelable(false);

        builder.setPositiveButton("SignUp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();;
    }
}


