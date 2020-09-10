package com.app.bemfapetipb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.bemfapetipb.Model.Report;
import com.app.bemfapetipb.Retrofit.ApiInterface;
import com.app.bemfapetipb.Utils.Common;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    private EditText mDeskripsi, mFasilitas;
    private ImageView mPicture;
    private FloatingActionButton mFabChoosePic;

    Button submit_btn;

    private String deskripsi, fasilitas;

    private Bitmap bitmap;

    ApiInterface mService;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        mService = Common.getAPI();

        mDeskripsi = findViewById(R.id.deskripsi);
        mFasilitas = findViewById(R.id.fasilitas);
        mPicture = findViewById(R.id.picture);
        submit_btn = findViewById(R.id.submit_btn);
        mFabChoosePic = findViewById(R.id.fabChoosePic);

        mDeskripsi.setVerticalScrollBarEnabled(true);
        mDeskripsi.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        mDeskripsi.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        mDeskripsi.setMovementMethod(ScrollingMovementMethod.getInstance());

        mDeskripsi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                view.getParent().requestDisallowInterceptTouchEvent(true);
                if ((motionEvent.getAction() & MotionEvent.ACTION_UP) != 0 && (motionEvent.getActionMasked() & MotionEvent.ACTION_UP) != 0)
                {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });

        mFabChoosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData("insert");
            }
        });

    }

    // Todo : Picture 2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                mPicture.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void postData(final String key) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving...");
        progressDialog.show();

        String fasilitas = mFasilitas.getText().toString().trim();
        String deskripsi = mDeskripsi.getText().toString().trim();

        String picture = null;
        if (bitmap == null) {
            picture = "";
        } else {
            picture = getStringImage(bitmap);
        }

        // apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // Todo : Picture 4
        Call<Report> call = mService.insertReport(key, fasilitas, deskripsi, picture);

        call.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {

                progressDialog.dismiss();

                Log.i(ReportActivity.class.getSimpleName(), response.toString());

                String value = response.body().getValue();
                String message = response.body().getMessage();

                if (value.equals("1")){
                    Toast.makeText(ReportActivity.this, "Laporan anda sudah terkirim", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ReportActivity.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                progressDialog.dismiss();
                // Toast.makeText(EditorActivity.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
}
