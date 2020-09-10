package com.app.bemfapetipb.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.bemfapetipb.R;
import com.app.bemfapetipb.Utils.ItemClickListener;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView article_image;
    TextView article_title, article_description, article_date;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ArticleViewHolder(View itemView) {
        super(itemView);

        article_image = (ImageView)itemView.findViewById(R.id.article_image);
        article_title = (TextView)itemView.findViewById(R.id.article_title);
        article_description = (TextView)itemView.findViewById(R.id.article_description);
        article_date = (TextView)itemView.findViewById(R.id.article_date);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }

}
