package com.app.bemfapetipb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.app.bemfapetipb.Adapter.ArticleAdapter;
import com.app.bemfapetipb.Model.Article;
import com.app.bemfapetipb.Retrofit.ApiInterface;
import com.app.bemfapetipb.Utils.Common;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EventActivity extends AppCompatActivity {

    ApiInterface mService;

    RecyclerView list_article;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private TextView toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        toolbar= findViewById(R.id.toolbar);

        toolbar.setText("Event");

        mService = Common.getAPI();

        list_article= (RecyclerView)findViewById(R.id.recycler_article);
        list_article.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        loadListArticle();
    }

    private void loadListArticle() {
        compositeDisposable.add(mService.getArticle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Article>>() {
                    @Override
                    public void accept(List<Article> articles) throws Exception {
                        displayArticleList(articles);
                    }
                }));

        // refresh(1000);
    }

    private void displayArticleList(List<Article> articles) {
        ArticleAdapter adapter = new ArticleAdapter(this, articles);
        list_article.setAdapter(adapter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
