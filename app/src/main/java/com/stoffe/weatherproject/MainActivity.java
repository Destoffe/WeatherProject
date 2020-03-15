package com.stoffe.weatherproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        TextView text = findViewById(R.id.textView2);








        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ProjectService service = RetrofitClientInstance.getRetrofitInstance().create(ProjectService.class);
                Call<TempModel> call = service.getAllTemp();
                call.enqueue(new Callback<TempModel>() {
                    @Override
                    public void onResponse(Call<TempModel> call, Response<TempModel> response) {
                        Log.d("APIDATA1",Float.toString(response.body().getTemperature()));
                        TempModel temp;
                        temp = new TempModel(response.body().getTemperature());
                        text.setText(temp.getTempString() + "\u2103");
                    }

                    @Override
                    public void onFailure(Call<TempModel> call, Throwable t) {
                        Log.d("APIDATA2",t.getMessage());
                    }
                });
            }
        });


    }
}
