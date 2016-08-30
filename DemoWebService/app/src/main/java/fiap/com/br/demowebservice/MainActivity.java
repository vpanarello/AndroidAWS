package fiap.com.br.demowebservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fiap.com.br.adapter.TimeAdapter;
import fiap.com.br.api.TimeApi;
import fiap.com.br.model.Time;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTimes;
    private List<Time> times = new ArrayList<>();
    private TimeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTimes = (RecyclerView) findViewById(R.id.rvTimes);

        adapter = new TimeAdapter(this, times);
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);

        rvTimes.setAdapter(adapter);

        carregaTimes();
    }

    private void carregaTimes() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.mocky.io")
                .build();

        TimeApi api = restAdapter.create(TimeApi.class);

        api.getTimes(new Callback<List<Time>>() {

            @Override
            public void success(List<Time> data, Response response) {
                times = data;
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this,
                        error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
