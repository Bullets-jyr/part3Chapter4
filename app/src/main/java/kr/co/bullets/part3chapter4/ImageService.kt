package kr.co.bullets.part3chapter4

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID YOUR_ACCESS_KEY")
    @GET("photos/random")
    fun getRandomImage(): Call<ImageResponse>
}