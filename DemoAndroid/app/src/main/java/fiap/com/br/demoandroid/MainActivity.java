package fiap.com.br.demoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private Spinner curso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.etNome);
        email = (EditText) findViewById(R.id.etEmail);
        curso = (Spinner) findViewById(R.id.spCurso);
    }


    

}
