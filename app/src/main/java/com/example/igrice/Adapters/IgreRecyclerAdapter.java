package com.example.igrice.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igrice.Model.Igre;
import com.example.igrice.Providers.IgreProvider;
import com.example.igrice.R;

import java.util.List;

public class IgreRecyclerAdapter extends RecyclerView.Adapter<IgreRecyclerAdapter.MyViewHolder> {
    private List<Igre> data;
    private OnElementClickListener listener;

    public IgreRecyclerAdapter(OnElementClickListener listener) {
        this.listener = listener; //4.
        data = IgreProvider.getAllIgrice();
    }

    public IgreRecyclerAdapter(OnElementClickListener listener, List<Igre> data) {
        this.listener = listener;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(listener, data.get(position).getNazivIgrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnElementClickListener {
        void onElementClicked(Igre igre);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;
        private View wholeView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            wholeView = itemView;
        }

        public void bind(final OnElementClickListener listener, final String item) {
            tvText.setText(item);
            wholeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onElementClicked(IgreProvider.getIgreByNaziv(item));
                }
            });
        }
    }
}

