package kr.co.bullets.part3chapter4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.bullets.part3chapter4.databinding.ActivityMainBinding
import kr.co.bullets.part3chapter4.mvc.MvcActivity
import kr.co.bullets.part3chapter4.mvi.MviActivity
import kr.co.bullets.part3chapter4.mvp.MvpActivity
import kr.co.bullets.part3chapter4.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun openMvc() {
        startActivity(Intent(this, MvcActivity::class.java))
    }

    fun openMvp() {
        startActivity(Intent(this, MvpActivity::class.java))
    }

    fun openMvvm() {
        startActivity(Intent(this, MvvmActivity::class.java))
    }

    fun openMvi() {
        startActivity(Intent(this, MviActivity::class.java))
    }
}