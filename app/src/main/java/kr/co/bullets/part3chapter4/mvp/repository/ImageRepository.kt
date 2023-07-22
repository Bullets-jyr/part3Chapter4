package kr.co.bullets.part3chapter4.mvp.repository

interface ImageRepository {
    fun getRandomImage(callback: Callback)

    interface Callback {
        fun loadImage(url: String, color: String)
    }
}