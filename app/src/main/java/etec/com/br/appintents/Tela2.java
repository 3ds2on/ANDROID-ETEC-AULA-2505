package etec.com.br.appintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {

    //OBJETOS PARA REFERENCIAR
    Button btVoltarT2,btCalcMasculino;
    EditText AlturaH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //EFETUAR A REFERENCIA DO OBJETO NO XML
        btVoltarT2 = findViewById(R.id.btnVoltaT2);
        AlturaH = findViewById(R.id.edV2);
        btCalcMasculino = findViewById(R.id.btnCalcMasc);

        //CÓDIGO DO BOTÃO CALCULAR
        btCalcMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TRATAMENTO DE CAMPOS VAZIOS
                if(AlturaH.getText().toString().isEmpty()){
                    AlturaH.requestFocus();
                    AlturaH.setError("Por gentileza, informe a sua altura!");
                }else{

                    //CRIANDO VARIAVEIS AUXILIARES
                    float pesoIdeal,AlturaHomem;

                    //CONVERTENDO VALORES DIGITADOS
                    AlturaHomem = Float.parseFloat(AlturaH.getText().toString());

                    //CALCULO PARA O PESO IDEAL
                    pesoIdeal=(72.7f * AlturaHomem)- 58f;

                    //CLIMITANDO O NUMERO DE CASAS DECIMAIS
                    DecimalFormat df = new DecimalFormat();

                    //EXIBINDO O RESULTADO COM O  TAST, LIMITANDO DUAS CASAS DECIMAIS APÓS A VIRGULA
                    Toast.makeText(Tela2.this, "Senhor, o seu peso ideal é: " + df.format(pesoIdeal), Toast.LENGTH_LONG).show();
                }
            }
        });

        //CÓDIGO DO BOTÃO VOLTAR
        btVoltarT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    //CÓDIGO PARA BLOQUEAR O VOLTAR DO CELULAR
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Senhor, para voltar, clique no botão!",Toast.LENGTH_SHORT).show();
    }
}
