package com.app.bemfapetipb.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.bemfapetipb.Model.DosenIntp;
import com.app.bemfapetipb.R;
import com.app.bemfapetipb.Utils.FilterIntp;

import java.util.ArrayList;
import java.util.List;

public class IntpAdapter extends RecyclerView.Adapter<IntpAdapter.MyViewHolder> implements Filterable {

    public List<DosenIntp> IntpList, IntpFilter;
    private Context context;
    private IntpAdapter.RecyclerViewClickListener mListener;
    FilterIntp filter;

    public IntpAdapter(List<DosenIntp> IntpList, Context context, IntpAdapter.RecyclerViewClickListener listener) {
        this.IntpList = IntpList;
        this.IntpFilter = IntpList;
        this.context = context;
        this.mListener = listener;
    }

    @Override
    public IntpAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_intp, parent, false);
        return new IntpAdapter.MyViewHolder(view, mListener);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final IntpAdapter.MyViewHolder holder, int position) {

        holder.mNip.setText(IntpList.get(position).getNip());
        holder.mNama.setText(IntpList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return IntpList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new FilterIntp((ArrayList<DosenIntp>) IntpFilter,this);

        }
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private IntpAdapter.RecyclerViewClickListener mListener;
        private TextView mNip, mNama;
        private RelativeLayout mRowContainer;

        public MyViewHolder(View itemView, IntpAdapter.RecyclerViewClickListener listener) {
            super(itemView);
            mNip = itemView.findViewById(R.id.nip);
            mNama = itemView.findViewById(R.id.nama);
            mRowContainer = itemView.findViewById(R.id.row_container);

            mListener = listener;
            mRowContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.row_container:
                    // mListener.onRowClick(mRowContainer, getAdapterPosition());
                    break;
                default:
                    break;
            }
        }
    }

    public interface RecyclerViewClickListener {
        // void onRowClick(View view, int position);
    }
}
