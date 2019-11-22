package com.example.retrofitbedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtv_post;
    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtv_post = findViewById(R.id.txtv_post);
        rcv = findViewById(R.id.rcv);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<User>> usersCall = apiService.getUsers();
        usersCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> users = response.body();
                    RcvAdapter rcvAdapter = new RcvAdapter(users);
                    rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rcv.setAdapter(rcvAdapter);
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


        Call<List<Post>> call = apiService.getPost();

        /*
         * async
         */
        /*call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    List<Post> posts = response.body();

                    for (Post post : posts){
                        Log.i("post", post.getTitle());

                        String item = "userId: " + post.getUserId()
                                + "\n id: " + post.getId()
                                + "\n Title " + post.getTitle()
                                + "\n Body " + post.getBody()
                                + "\n\n";


                        //txtv_post.setText(item);
                        txtv_post.append(item);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Codigo: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
