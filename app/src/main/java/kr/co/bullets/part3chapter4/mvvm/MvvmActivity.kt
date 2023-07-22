package kr.co.bullets.part3chapter4.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.co.bullets.part3chapter4.R
import kr.co.bullets.part3chapter4.databinding.ActivityMvvmBinding
import kr.co.bullets.part3chapter4.mvvm.repository.ImageRepositoryImpl

class MvvmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmBinding

    private val viewModel: MvvmViewModel by viewModels {
        MvvmViewModel.MvvmViewModelFactory(ImageRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.lifecycleOwner = this
            it.view = this
            it.viewModel = viewModel
        }
    }

    fun loadImage() {
        viewModel.loadRandomImage()
    }
}