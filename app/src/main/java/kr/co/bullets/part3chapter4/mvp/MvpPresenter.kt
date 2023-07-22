package kr.co.bullets.part3chapter4.mvp

import kr.co.bullets.part3chapter4.mvp.model.ImageCountModel
import kr.co.bullets.part3chapter4.mvp.repository.ImageRepository

class MvpPresenter(private val model: ImageCountModel, private val imageRepository: ImageRepository) : MvpContractor.Presenter, ImageRepository.Callback {
    private var view: MvpContractor.View? = null

    override fun attachView(view: MvpContractor.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadRandomImage() {
        imageRepository.getRandomImage(this)
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        view?.showImage(url, color)
        view?.showImageCountText(model.count)
    }
}