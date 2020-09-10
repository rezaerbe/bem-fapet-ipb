package com.app.bemfapetipb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bemfapetipb.EventDetailActivity;
import com.app.bemfapetipb.Model.Article;
import com.app.bemfapetipb.R;
import com.app.bemfapetipb.Utils.ItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    Context context;
    List<Article> articleList;

    public String article_id, title, date, deskripsi, picture;

    public ArticleAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item_layout, parent, false);
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, final int position) {
        holder.article_title.setText(articleList.get(position).title);
        holder.article_description.setText(articleList.get(position).deskripsi);
        holder.article_date.setText(articleList.get(position).date);

        article_id = articleList.get(position).id;
        title = articleList.get(position).title;
        date = articleList.get(position).date;
        deskripsi = articleList.get(position).deskripsi;
        picture = articleList.get(position).picture;

//        Picasso.get()
//                .load(articleList.get(position).image)
//                .into(holder.article_image);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.ic_launcher_background);
        requestOptions.error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(articleList.get(position).picture)
                .apply(requestOptions)
                .into(holder.article_image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("article_id", article_id);
                intent.putExtra("title", title);
                intent.putExtra("date", date);
                intent.putExtra("deskripsi", deskripsi);
                intent.putExtra("picture", picture);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}