package fiap.com.br.kawabanga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PedidoActivity extends AppCompatActivity {

    private TextView tvUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        tvUsuario = (TextView) findViewById(R.id.tvUsuario);

        tvUsuario.setText(getIntent().getStringExtra("usuario"));
    }
}
