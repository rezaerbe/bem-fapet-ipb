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

import com.app.bemfapetipb.Model.DosenIptp;
import com.app.bemfapetipb.R;
import com.app.bemfapetipb.Utils.FilterIptp;

import java.util.ArrayList;
import java.util.List;

public class IptpAdapter extends RecyclerView.Adapter<IptpAdapter.MyViewHolder> implements Filterable {

    public List<DosenIptp> IptpList, IptpFilter;
    private Context context;
    private IptpAdapter.RecyclerViewClickListener mListener;
    FilterIptp filter;

    public IptpAdapter(List<DosenIptp> IptpList, Context context, IptpAdapter.RecyclerViewClickListener listener) {
        this.IptpList = IptpList;
        this.IptpFilter = IptpList;
        this.context = context;
        this.mListener = listener;
    }

    @Override
    public IptpAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iptp, parent, false);
        return new IptpAdapter.MyViewHolder(view, mListener);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final IptpAdapter.MyViewHolder holder, int position) {

        holder.mNip.setText(IptpList.get(position).getNip());
        holder.mNama.setText(IptpList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return IptpList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new FilterIptp((ArrayList<DosenIptp>) IptpFilter,this);

        }
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private IptpAdapter.RecyclerViewClickListener mListener;
        private TextView mNip, mNama;
        private RelativeLayout mRowContainer;

        public MyViewHolder(View itemView, IptpAdapter.RecyclerViewClickListener listener) {
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
