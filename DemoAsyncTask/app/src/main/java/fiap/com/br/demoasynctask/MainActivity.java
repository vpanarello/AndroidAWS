package fiap.com.br.demoasynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImagem;
    private Button btRevelar;

    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImagem = (ImageView) findViewById(R.id.ivImagem);
        btRevelar = (Button) findViewById(R.id.btRevelar);

        btRevelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CarregaImagem()
                        .execute("http://www.nerddogueto.com.br/wordpress/wp-content/uploads/2010/03/dollynho.jpg");
            }
        });
    }

    private class CarregaImagem
            extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("... Carregando a Imagem ... ");
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;

            try {
                bitmap = BitmapFactory
                        .decodeStream((InputStream) new URL(params[0])
                                .getContent());

            } catch(Exception ex) {

            }
            return bitmap;
        }
    }

    protected  void onPostExecute(Bitmap bitmap) {
        if(bitmap == null) {
            Toast.makeText(MainActivity.this, "Não foi possível localizar a imagem", Toast.LENGTH_LONG).show();
        } else {
            ivImagem.setImageBitmap(bitmap);
        }
        pDialog.dismiss();
    }
}
