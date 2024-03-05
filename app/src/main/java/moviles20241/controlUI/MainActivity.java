package moviles20241.controlUI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textoPantalla;
    private EditText textoEntrada;
    private ImageButton botonEstrella;
    private CheckBox checheador;
    private Switch switchPrueba;
    private RadioGroup grupoOpciones;
    private Button botonAzul;
    private Button botonVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        textoPantalla = (TextView) findViewById( R.id.helloWorld );
        textoPantalla.setTextSize( 30 );
        textoPantalla.setTextColor( Color.RED );
        textoPantalla.setText( "Bienvenido" );

        textoEntrada = (EditText) findViewById( R.id.editTextNumber );
        textoEntrada.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textoPantalla.setText( textoEntrada.getText().toString() );
            }
        } );

        botonAzul = (Button) findViewById( R.id.buttonAzul );
        botonVerde = (Button) findViewById( R.id.buttonVerde );
        botonAzul.setOnClickListener( this );
        botonVerde.setOnClickListener( this );

        botonEstrella = (ImageButton) findViewById( R.id.imageButton );
        botonEstrella.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoPantalla.setTextSize( 50 );
            }
        } );

        checheador = (CheckBox) findViewById( R.id.checkBox );
        checheador.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textoPantalla.setText( "Check" );
                }
                else{
                    textoPantalla.setText( "No Check" );
                }
            }
        } );

        switchPrueba = (Switch) findViewById( R.id.switch1 );

        grupoOpciones = (RadioGroup) findViewById( R.id.grupo);
        grupoOpciones.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonAzul){
                    textoPantalla.setTextColor( Color.BLUE);
                }else if(i==R.id.radioButtonVerde){
                    textoPantalla.setTextColor( Color.GREEN);
                }
            }
        } );
    }

    public void cambiarColor(View v){
        textoPantalla.setTextColor( Color.YELLOW);
    }

    public void revisarCheck(View v){
        if(switchPrueba.isChecked()){
            textoPantalla.setText( "Check" );
        }
        else{
            textoPantalla.setText( "No Check" );
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonAzul){
            textoPantalla.setTextColor( Color.BLUE);
        }else if(view.getId() == botonVerde.getId()){
            textoPantalla.setTextColor( Color.GREEN);
        }
    }
}