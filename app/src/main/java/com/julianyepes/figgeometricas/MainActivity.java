package com.julianyepes.figgeometricas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sin;
import static java.lang.Math.atan2;
import static java.lang.Math.PI;

public class MainActivity extends AppCompatActivity {

    EditText eMedida1,eMedida2;
    Button  bCalcular;
    RadioButton rbCuadro,rbCirculo,rbTriangulo,rbCubo;
    TextView tResultado;
    int flag=0;
    Double area,peri,medida1,medida2,theta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMedida1 = (EditText) findViewById(R.id.eMedida1);
        eMedida2 = (EditText) findViewById(R.id.eMedida2);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        tResultado = (TextView)findViewById(R.id.tResult);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (flag){
                    case 1:
                        if( !eMedida1.getText().toString().equals("") ){
                            medida1 = Double.parseDouble( eMedida1.getText().toString() );
                            area=medida1*medida1;
                            peri=medida1*4;
                            tResultado.setText("Area="+area.toString()+" \nPeri="+peri.toString() );
                        }else{
                            Toast.makeText(getApplicationContext(),"Ingrese el lado", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 2:
                        if( !eMedida1.getText().toString().equals("") ){
                            medida1 = Double.parseDouble( eMedida1.getText().toString() );
                            area=PI*medida1*medida1;
                            peri=2*PI*medida1;
                            tResultado.setText("Area="+area.toString()+" \nPeri="+peri.toString() );
                        }else{
                            Toast.makeText(getApplicationContext(),"Ingrese el radio", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        if( !eMedida1.getText().toString().equals("") && !eMedida2.getText().toString().equals("")){
                            medida1 = Double.parseDouble( eMedida1.getText().toString() );
                            medida2 = Double.parseDouble( eMedida2.getText().toString() );
                            area=0.5*medida1*medida2;
                            theta=atan2(medida2,medida1);
                            peri=medida2/sin(theta);
                            peri=peri*2+medida1;
                            tResultado.setText("Area="+area.toString()+" \nPeri="+peri.toString() );
                        }else{
                            Toast.makeText(getApplicationContext(),"Ingrese medidas", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        if( !eMedida1.getText().toString().equals("") ){
                            medida1 = Double.parseDouble( eMedida1.getText().toString() );
                            area=medida1*medida2*medida1;
                            tResultado.setText("Volumen="+area.toString() );
                        }else{
                            Toast.makeText(getApplicationContext(),"Ingrese lado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"Escoja figura", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.rbCudro:
                eMedida1.setHint("Lado");
                eMedida1.setText("");
                eMedida2.setVisibility(View.INVISIBLE);
                flag=1;
                break;
            case R.id.rbCirculo:
                eMedida1.setHint("Radio");
                eMedida1.setText("");
                eMedida2.setVisibility(View.INVISIBLE);
                flag=2;
                break;
            case R.id.rbTriangulo:
                eMedida1.setHint("Base");
                eMedida1.setText("");
                eMedida2.setVisibility(View.VISIBLE);
                eMedida2.setHint("Altura");
                eMedida2.setText("");
                flag=3;
                break;
            case R.id.rbCubo:
                eMedida1.setText("");
                eMedida1.setHint("Lado");
                eMedida2.setVisibility(View.INVISIBLE);
                flag=4;
                break;
        }
    }
}
