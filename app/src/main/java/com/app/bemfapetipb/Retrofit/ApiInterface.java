package com.app.bemfapetipb.Retrofit;

import com.app.bemfapetipb.Model.Article;
import com.app.bemfapetipb.Model.DosenIntp;
import com.app.bemfapetipb.Model.DosenIptp;
import com.app.bemfapetipb.Model.Mahasiswa;
import com.app.bemfapetipb.Model.Report;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("getMahasiswa.php")
    Call<List<Mahasiswa>> getMahasiswa();

    @POST("getIntp.php")
    Call<List<DosenIntp>> getIntp();

    @POST("getIptp.php")
    Call<List<DosenIptp>> getIptp();

    @FormUrlEncoded
    @POST("add_report.php")
    Call<Report> insertReport(
            @Field("key") String key,
            @Field("fasilitas") String fasilitas,
            @Field("deskripsi") String deskripsi,
            @Field("picture") String picture);

    @POST("get_article.php")
    Observable<List<Article>> getArticle();
}
