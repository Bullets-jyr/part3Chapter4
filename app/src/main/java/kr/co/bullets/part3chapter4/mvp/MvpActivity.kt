package kr.co.bullets.part3chapter4.mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import kr.co.bullets.part3chapter4.R
import kr.co.bullets.part3chapter4.databinding.ActivityMvpBinding
import kr.co.bullets.part3chapter4.mvp.model.ImageCountModel
import kr.co.bullets.part3chapter4.mvp.repository.ImageRepositoryImp

class MvpActivity : AppCompatActivity(), MvpContractor.View {
    private lateinit var binding: ActivityMvpBinding
    private lateinit var presenter: MvpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }

        presenter = MvpPresenter(ImageCountModel(), ImageRepositoryImp())
        presenter.attachView(this)
    }

    fun loadImage() {
        presenter.loadRandomImage()
    }

    override fun showImage(url: String, color: String) {
        binding.imageView.run {
            setBackgroundColor(Color.parseColor(color))
            load(url) {
                crossfade(300)
            }
        }
    }

    override fun showImageCountText(count: Int) {
        binding.imageCountTextView.text = "불러온 이미지 수: $count"
    }
}