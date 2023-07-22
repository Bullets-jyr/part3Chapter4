package kr.co.bullets.part3chapter4.mvi

import kr.co.bullets.part3chapter4.mvi.model.Image

sealed class MviState {
    // 초기값
    object Idle: MviState()
    //
    object Loading: MviState()
    //
    data class LoadedImage(val image: Image, val count: Int): MviState()
}
