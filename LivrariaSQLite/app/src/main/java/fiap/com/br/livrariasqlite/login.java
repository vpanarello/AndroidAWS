package fiap.com.br.livrariasqlite;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class login extends AppCompatActivity {

    final String PREF_NAME = "LIVRARIA";
    private TextInputLayout tiUsername;
    private TextInputLayout tiPassword;
    private CheckBox ckManterConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tiUsername = (TextInputLayout) findViewById(R.id.tiUsername);
        tiPassword = (TextInputLayout) findViewById(R.id.tiPassword);
        ckManterConectado = (CheckBox) findViewById(R.id.ckManterConectado);

        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if (sp.getBoolean("manterConectado", false)){
            Intent telaPrincipal = new Intent(this, MainActivity.class);
            telaPrincipal.putExtra("nome", tiUsername.getEditText().getText().toString());
            startActivity(telaPrincipal);
            finish(); // Finaliza essa tela
        }
    }


    public void doLogin(View v) {
        if (tiUsername.getEditText().getText().toString().equals("fiap")
                && tiPassword.getEditText().getText().toString().equals("123")) {


            if (ckManterConectado.isChecked()) {
                // Armazena definicoes localmente no device
                SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("manterConectado", ckManterConectado.isChecked());
                editor.commit();
            }

            // Pular para a proxima tela (Intecao de pular para proxima tela)
            Intent telaPrincipal = new Intent(this, MainActivity.class);
            telaPrincipal.putExtra("nome", tiUsername.getEditText().getText().toString());
            startActivity(telaPrincipal);
            finish(); // Finaliza essa tela

        } else {
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();

        }
    }
}
