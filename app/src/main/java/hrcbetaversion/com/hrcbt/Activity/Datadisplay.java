package hrcbetaversion.com.hrcbt.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import hrcbetaversion.com.hrcbt.Adapter.DatadisplyAdapter;
import hrcbetaversion.com.hrcbt.Response.DiagonsticResponse;
import hrcbetaversion.com.hrcbt.R;
import hrcbetaversion.com.hrcbt.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Datadisplay extends AppCompatActivity {
    RecyclerView recyclerView;
    DatadisplyAdapter datadisplyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadisplay);
        recyclerView=findViewById(R.id.data_Display);

        getData();

    }

    private void getData() {
        Call<DiagonsticResponse> call = Utils.getWebService().DIAGONSTIC_RESPONSE_CALL();
        Log.e("DigonsticResponse", "getData: "+call.request().toString());
        call.enqueue(new Callback<DiagonsticResponse>() {
            @Override
            public void onResponse(Call<DiagonsticResponse> call, Response<DiagonsticResponse> response) {
                DiagonsticResponse diagonsticResponse=response.body();
                Log.e("DigonsticResponse"," onResponse: "+new GsonBuilder().create().toJson(diagonsticResponse));
                if (diagonsticResponse.getStatus()==200){
                    datadisplyAdapter= new DatadisplyAdapter( Datadisplay.this,diagonsticResponse.getResponse());
                    recyclerView.setLayoutManager(new LinearLayoutManager(Datadisplay.this));
                    recyclerView.setAdapter(datadisplyAdapter);

                    if(response.code()==200){

                        if(diagonsticResponse.getStatus()==200){

                }else {
                    Toast.makeText(Datadisplay.this,"Something went wrong",Toast.LENGTH_SHORT).show();

                }

            }else {
                Toast.makeText(Datadisplay.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }

            }

        }

            @Override
            public void onFailure(Call<DiagonsticResponse> call, Throwable t) {

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

}
