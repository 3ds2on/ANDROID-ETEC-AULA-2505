package etec.com.br.appintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //OBJETOS PARA REFERENCIAR
    Button btUm, btDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EFETUAR A REFERENCIA DO OBJETO NO XML
        btUm = findViewById(R.id.btfeminino);
        btDois = findViewById(R.id.btmasculino);


        //CODIGO DO PRIMEIRO BOTAO FEMININO
        btUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela1 = new Intent(MainActivity.this,Tela1.class);
                startActivity(tela1);
            }
        });

        //CODIGO DO SEGUNDO BOTAO MASCULINO
        btDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela2 = new Intent(MainActivity.this,Tela2.class);
                startActivity(tela2);

            }
        });
    }

}

