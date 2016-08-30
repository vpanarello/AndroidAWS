package fiap.com.br.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fiap.com.br.demowebservice.R;
import fiap.com.br.model.Time;

/**
 * Created by RM30222 on 29/08/2016.
 */

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {

    private List<Time> times;
    private Context context;

    public class TimeViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNome, tvEstado, tvAno;
        public ImageView ivTime;

        public TimeViewHolder(View itemView) {
            super(itemView);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvEstado = (TextView) itemView.findViewById(R.id.tvEstado);
            tvAno = (TextView) itemView.findViewById(R.id.tvAno);
            ivTime = (ImageView) itemView.findViewById(R.id.ivTime);
        }
    }

    public TimeAdapter(Context context, List<Time> times) {
        this.times = times;
        this.context = context;
    }

    public int getItemCount(){
        return this.times.size();
    }
    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.time_item, parent, false);
        return new TimeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(TimeViewHolder holder,
                                 int position) {

        Time time = times.get(position);
        holder.tvAno.setText(String.valueOf(time.getAnoFundacao()));
        holder.tvEstado.setText(time.getEstado());
        holder.tvNome.setText(time.getNome());
        Picasso.with(context)
                .load(time.getEscudo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivTime);
    }
}
