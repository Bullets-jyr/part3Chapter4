package kr.co.bullets.part3chapter4.mvvm.repository

import io.reactivex.Single
import kr.co.bullets.part3chapter4.mvvm.model.Image

interface ImageRepository {
    fun getRandomImage(): Single<Image>
}