package br.com.fiap.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);

    }

    public void sysLogIn(View view) {
        if(etUser.getText().toString().equals("Dunha") && etPass.getText().toString().equals("123")) {
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("nome",etUser.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuário Inválido", Toast.LENGTH_LONG).show();
        }

    }


}
