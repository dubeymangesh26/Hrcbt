package hrcbetaversion.com.hrcbt.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import hrcbetaversion.com.hrcbt.Adapter.ProgrammingAdapter;
import hrcbetaversion.com.hrcbt.R;
import hrcbetaversion.com.hrcbt.Response.HomeDataResponse;
import hrcbetaversion.com.hrcbt.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;

    RecyclerView programmingList;
    ProgrammingAdapter programmingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.btn_Go);
        b1.setOnClickListener(this);

        programmingList=findViewById(R.id.programmingList);

        getData();
    }

    private void getData() {

        Call<HomeDataResponse> call = Utils.getWebService().getHomeData();
        Log.e("Home", "getData: "+call.request().toString());
        call.enqueue(new Callback<HomeDataResponse>() {
            @Override
            public void onResponse(Call<HomeDataResponse> call, Response<HomeDataResponse> response) {
                HomeDataResponse homeDataResponse = response.body();
                Log.e("HomeDataResponse ", "onResponse: "+new GsonBuilder().create().toJson(homeDataResponse));
                if(response.code()==200){

                    if(homeDataResponse.getStatus()==200){

                        programmingAdapter = new ProgrammingAdapter(MainActivity.this,homeDataResponse.getResponse());
                        programmingList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        programmingList.setAdapter(programmingAdapter);




                    }else {
                        Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomeDataResponse> call, Throwable t) {

            }
        });
    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);

        }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Datadisplay.class);
        startActivity(intent);


    }
}
