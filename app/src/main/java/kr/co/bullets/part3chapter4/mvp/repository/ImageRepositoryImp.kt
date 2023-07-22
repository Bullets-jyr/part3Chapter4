package kr.co.bullets.part3chapter4.mvp.repository

import kr.co.bullets.part3chapter4.ImageResponse
import kr.co.bullets.part3chapter4.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepositoryImp : ImageRepository {
    override fun getRandomImage(callback: ImageRepository.Callback) {
        RetrofitManager.imageService.getRandomImage().enqueue(object : Callback<ImageResponse> {
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.loadImage(it.urls.regular, it.color)
                    }
                }
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {

            }
        })
    }
}