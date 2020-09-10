package com.app.bemfapetipb.Utils;

import android.widget.Filter;

import com.app.bemfapetipb.Adapter.MahasiswaAdapter;
import com.app.bemfapetipb.Model.Mahasiswa;

import java.util.ArrayList;


public class CustomFilter extends Filter {

    MahasiswaAdapter adapter;
    ArrayList<Mahasiswa> filterList;

    public CustomFilter(ArrayList<Mahasiswa> filterList, MahasiswaAdapter adapter)
    {
        this.adapter = adapter;
        this.filterList = filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Mahasiswa> filteredMahasiswa = new ArrayList<>();

            for (int i = 0 ; i < filterList.size() ; i++)
            {
                //CHECK
                if(filterList.get(i).getNama().contains(constraint) || filterList.get(i).getNim().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredMahasiswa.add(filterList.get(i));
                }
            }

            results.count = filteredMahasiswa.size();
            results.values = filteredMahasiswa;

        }else
        {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.mahasiswaList = (ArrayList<Mahasiswa>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();

    }
}
