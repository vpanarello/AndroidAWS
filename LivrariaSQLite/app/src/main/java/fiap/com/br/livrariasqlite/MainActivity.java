package fiap.com.br.livrariasqlite;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import br.com.fiap.dao.LivrosDao;
import br.com.fiap.model.Livro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void testeDB() {
        LivrosDao dao = new LivrosDao(this);

        SharedPreferences sp = getSharedPreferences("LIVRARIA", MODE_PRIVATE);

        if(sp.getBoolean("ALREADY_INSERTED", false)) {



        } else {
            dao.add(new Livro("Google Android", "Ricardo Lochetta"));
            dao.add(new Livro("Crepusculo", "stephanie Meyer"));
            dao.add(new Livro("50 tons de cinza", "EL James"));

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("ALREADY_INSERTED", true);

            editor.commit();
        }
        List<Livro> livros = dao.getAll();

        for (Livro livro : livros) {
            Log.i("LIVRO", livro.getTitulo());
        }
    }
}
