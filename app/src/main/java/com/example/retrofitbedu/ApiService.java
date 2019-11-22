package com.example.retrofitbedu;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPost();

    @GET("users")
    Call<List<User>> getUsers();
}
