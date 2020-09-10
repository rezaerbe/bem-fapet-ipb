package com.app.bemfapetipb.Utils;

import android.widget.Filter;

import com.app.bemfapetipb.Adapter.IptpAdapter;
import com.app.bemfapetipb.Model.DosenIptp;

import java.util.ArrayList;

public class FilterIptp extends Filter {

    IptpAdapter adapter;
    ArrayList<DosenIptp> filterList;

    public FilterIptp(ArrayList<DosenIptp> filterList, IptpAdapter adapter)
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
            ArrayList<DosenIptp> filteredIptp = new ArrayList<>();

            for (int i = 0 ; i < filterList.size() ; i++)
            {
                //CHECK
                if(filterList.get(i).getNama().toLowerCase().contains(constraint) || filterList.get(i).getNip().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredIptp.add(filterList.get(i));
                }
            }

            results.count = filteredIptp.size();
            results.values = filteredIptp;

        }else
        {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.IptpList = (ArrayList<DosenIptp>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();

    }
}
