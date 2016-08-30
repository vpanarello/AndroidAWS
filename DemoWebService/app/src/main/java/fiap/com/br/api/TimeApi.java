package fiap.com.br.api;

import java.util.List;

import fiap.com.br.model.Time;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by RM30222 on 29/08/2016.
 */
public interface TimeApi {


    @GET("/v2/57c49ba10f00007111b50c00")
    public void getTimes(Callback<List<Time>> response);


}
