package com.app.bemfapetipb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class EventDetailActivity extends AppCompatActivity {

    public String article_id, title, date, deskripsi, picture;

    public TextView article_title, article_date, article_description;

    public ImageView article_image;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        article_title = findViewById(R.id.article_title);
        article_date = findViewById(R.id.article_date);
        article_description = findViewById(R.id.article_description);
        article_image = findViewById(R.id.article_image);

        Intent intent = getIntent();
        article_id = intent.getStringExtra("article_id");
        title = intent.getStringExtra("title");
        date = intent.getStringExtra("date");
        deskripsi = intent.getStringExtra("deskripsi");
        picture = intent.getStringExtra("picture");

        article_title.setText(title);
        article_date.setText(date);
        article_description.setText(deskripsi);

        loadImage();
    }

    private void loadImage() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.ic_launcher_background);
        requestOptions.error(R.drawable.ic_launcher_background);

        Glide.with(this)
                .load(picture)
                .apply(requestOptions)
                .into(article_image);
    }


}
