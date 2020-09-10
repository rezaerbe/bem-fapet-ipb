package com.app.bemfapetipb.Utils;

import android.widget.Filter;

import com.app.bemfapetipb.Adapter.IntpAdapter;
import com.app.bemfapetipb.Model.DosenIntp;

import java.util.ArrayList;

public class FilterIntp extends Filter {

    IntpAdapter adapter;
    ArrayList<DosenIntp> filterList;

    public FilterIntp(ArrayList<DosenIntp> filterList, IntpAdapter adapter)
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
            constraint = constraint.toString().toLowerCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<DosenIntp> filteredIntp = new ArrayList<>();

            for (int i = 0 ; i < filterList.size() ; i++)
            {
                //CHECK
                if(filterList.get(i).getNama().toLowerCase().contains(constraint) || filterList.get(i).getNip().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredIntp.add(filterList.get(i));
                }
            }

            results.count = filteredIntp.size();
            results.values = filteredIntp;

        }else
        {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.IntpList = (ArrayList<DosenIntp>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();

    }
}
