package com.example.apirest.data.remote

import com.example.apirest.data.model.Post
import retrofit2.http.GET



interface ApiService {
    @GET(value="/posts")
    suspend fun getPosts(): List<Post>

}