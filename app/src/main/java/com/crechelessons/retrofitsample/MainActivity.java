package com.crechelessons.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crechelessons.retrofitsample.model.ModelClass;
import com.crechelessons.retrofitsample.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String BASE_URL = "http://api.open-notify.org/";
    private Call<ModelClass> call;
    private ApiInterface apiInterface;
    private TextView latValue, longValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        Button updateBtn = findViewById(R.id.update);
        latValue = findViewById(R.id.value_latitude);
        longValue = findViewById(R.id.valuelongitude);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValues();
            }
        });
    }

    private void updateValues() {
        call = apiInterface.getData();
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                Log.d(TAG, response.body().getMessage().toString());
                latValue.setText(response.body().getIss_position().getLatitude());
                longValue.setText(response.body().getIss_position().getLongitude());
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.d(TAG, "Something went wrong... " + t.getMessage());
            }
        });
    }

}

