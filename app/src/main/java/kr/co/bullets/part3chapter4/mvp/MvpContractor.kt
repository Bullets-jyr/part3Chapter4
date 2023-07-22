package kr.co.bullets.part3chapter4.mvp

interface MvpContractor {

    interface View {
        fun showImage(url: String, color: String)

        fun showImageCountText(count: Int)
    }

    interface Presenter {
        fun attachView(view: View)

        fun detachView()

        fun loadRandomImage()
    }
}