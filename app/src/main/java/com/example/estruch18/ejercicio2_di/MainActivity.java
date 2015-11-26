package com.example.estruch18.ejercicio2_di;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    //ATRIBUTOS DE LA CLASE
    private RadioGroup grupoFondo, grupoTexto;
    private CheckBox mostrarTexto;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EJECUCIÓN DE MÉTODOS
        declaracionViews();
        setColorFondoTextView();
        setColorTextoTextView();
        mostrarTexto();
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

    //Método cuya finalidad es declarar los diferentes controles
    public void declaracionViews(){
        grupoFondo = (RadioGroup)findViewById(R.id.grupoFondo);
        grupoTexto = (RadioGroup)findViewById(R.id.grupoTexto);
        texto = (TextView)findViewById(R.id.tvTexto);
        mostrarTexto = (CheckBox)findViewById(R.id.cbMostrarTexto);
    }

    //Método encargado de establecer un color de fondo segun selección en Radio
    public void setColorFondoTextView(){
        grupoFondo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int idRadioSelected = grupoFondo.getCheckedRadioButtonId();
                RadioButton radioSelected = (RadioButton) findViewById(idRadioSelected);
                String colorSeleccionado = radioSelected.getText().toString();

                if(colorSeleccionado.equals("Fondo negro")){
                    texto.setBackgroundColor(Color.BLACK);
                }
                else if(colorSeleccionado.equals("Fondo verde")){
                    texto.setBackgroundColor(Color.GREEN);
                }
                else{
                    texto.setBackgroundColor(Color.RED);
                }

            }
        });
    }

    //Método encargado de establecer un color de texto segun selección en Radio
    public void setColorTextoTextView(){
        grupoTexto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int idRadioSelected = grupoTexto.getCheckedRadioButtonId();
                RadioButton radioSelected = (RadioButton) findViewById(idRadioSelected);
                String colorTextoSeleccionado = radioSelected.getText().toString();

                if(colorTextoSeleccionado.equals("Texto blanco")){
                    texto.setTextColor(Color.WHITE);
                }
                else if(colorTextoSeleccionado.equals("Texto amarillo")){
                    texto.setTextColor(Color.YELLOW);
                }
                else{
                    texto.setTextColor(Color.BLUE);
                }
            }
        });
    }
    //Método encargado de mostrar u ocultar el texto del TextView situado en la parte superior de la pantalla
    public void mostrarTexto(){
        mostrarTexto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mostrarTexto.isChecked()){
                    texto.setVisibility(View.VISIBLE);
                    texto.setText("TEXTO");
                }
                else{
                    texto.setText("");
                }
            }
        });
    }
}
