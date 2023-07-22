package kr.co.bullets.part3chapter4.mvc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import kr.co.bullets.part3chapter4.R
import kr.co.bullets.part3chapter4.databinding.ActivityMvcBinding
import kr.co.bullets.part3chapter4.mvc.provider.ImageProvider

class MvcActivity : AppCompatActivity(), ImageProvider.Callback {
    private lateinit var binding: ActivityMvcBinding
    private val model = ImageCountModel()
    private val imageProvider = ImageProvider(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun loadImage() {
        imageProvider.getRandomImage()
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        with(binding) {
            imageView.run {
                setBackgroundColor(Color.parseColor(color))
                load(url)
            }
            imageCountTextView.text = "불러온 이미지 수: ${model.count}"
        }
    }
}