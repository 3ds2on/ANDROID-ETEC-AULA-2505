package etec.com.br.appintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela1 extends AppCompatActivity {

    //OBJETOS PARA REFERENCIAR
    Button btVoltarT1,btCalcFeminino;
    EditText AlturaM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //EFETUAR A REFERENCIA DO OBJETO NO XML
        btVoltarT1 = findViewById(R.id.btnVoltaT1);
        AlturaM = findViewById(R.id.edV1);
        btCalcFeminino = findViewById(R.id.btnCalcFem);

        //CÓDIGO DO BOTÃO CALCULAR
        btCalcFeminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TRATAMENTO DE CAMPOS VAZIOS
                if(AlturaM.getText().toString().isEmpty()){
                    AlturaM.requestFocus();
                    AlturaM.setError("Por gentileza, informe a sua altura!");
                }else{

                    //CRIANDO VARIAVEIS AUXILIARES
                    float pesoIdeal,AlturaMulher;

                    //CONVERTENDO VALORES DIGITADOS
                    AlturaMulher = Float.parseFloat(AlturaM.getText().toString());

                    //CALCULO PARA O PESO IDEAL
                    pesoIdeal=(62.1f * AlturaMulher)- 44.7f;

                    //CLIMITANDO O NUMERO DE CASAS DECIMAIS
                    DecimalFormat df = new DecimalFormat();

                    //EXIBINDO O RESULTADO COM O  TAST, LIMITANDO DUAS CASAS DECIMAIS APÓS A VIRGULA
                    Toast.makeText(Tela1.this, "Senhora, o seu peso ideal é: " + df.format(pesoIdeal), Toast.LENGTH_LONG).show();
                }
            }
        });

        //CÓDIGO DO BOTÃO VOLTAR
        btVoltarT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });

    }

    //CÓDIGO PARA BLOQUEAR O VOLTAR DO CELULAR
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Senhora, para voltar, clique no botão!",Toast.LENGTH_SHORT).show();
    }
}