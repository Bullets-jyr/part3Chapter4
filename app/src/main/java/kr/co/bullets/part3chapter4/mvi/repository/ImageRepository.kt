package kr.co.bullets.part3chapter4.mvi.repository

import kr.co.bullets.part3chapter4.mvi.model.Image

interface ImageRepository {
    suspend fun getRandomImage(): Image
}