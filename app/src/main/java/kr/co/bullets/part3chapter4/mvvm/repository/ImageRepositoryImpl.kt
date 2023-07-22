package kr.co.bullets.part3chapter4.mvvm.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.co.bullets.part3chapter4.RetrofitManager
import kr.co.bullets.part3chapter4.mvvm.model.Image

class ImageRepositoryImpl : ImageRepository {
    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }
}