package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.FAQs;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<FAQs> dades;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<FAQs> FAQsList, Context context) {
        this.dades = FAQsList;
        this.mInflater = LayoutInflater.from((Context) context);
        this.context = (Context) context;
    }


    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.activity_followers_list, null);
        return new ListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, int position) {
        holder.bindData(dades.get(position));
    }

    @Override
    public int getItemCount() {
        return dades.size();
    }

    public void setItems(List<FAQs> items){
        dades=items;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView respuesta;
        TextView pregunta;

        MyViewHolder(View itemView){
            super(itemView);
            pregunta=itemView.findViewById(R.id.PreguntaTextView);
            respuesta=itemView.findViewById(R.id.respuestaTextView);
        }

        void bindData(final FAQs FAQ){
            pregunta.setText(FAQ.getPregunta());
            respuesta.setText(FAQ.getRespuesta());

        }

    }
}
