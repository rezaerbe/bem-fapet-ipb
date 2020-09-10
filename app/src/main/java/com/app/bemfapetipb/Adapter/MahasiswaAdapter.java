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

import com.app.bemfapetipb.Model.Mahasiswa;
import com.app.bemfapetipb.R;
import com.app.bemfapetipb.Utils.CustomFilter;

import java.util.ArrayList;
import java.util.List;



public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> implements Filterable {

    public List<Mahasiswa> mahasiswaList, mahasiswaFilter;
    private Context context;
    private RecyclerViewClickListener mListener;
    CustomFilter filter;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList, Context context, RecyclerViewClickListener listener) {
        this.mahasiswaList = mahasiswaList;
        this.mahasiswaFilter = mahasiswaList;
        this.context = context;
        this.mListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MyViewHolder(view, mListener);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mNim.setText(mahasiswaList.get(position).getNim());
        holder.mNama.setText(mahasiswaList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter((ArrayList<Mahasiswa>) mahasiswaFilter,this);

        }
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewClickListener mListener;
        private TextView mNim, mNama;
        private RelativeLayout mRowContainer;

        public MyViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mNim = itemView.findViewById(R.id.nim);
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
