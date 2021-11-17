package app.hankdev.reactivexandroiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import app.hankdev.reactivexandroiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        binding.submit.setOnClickListener {
            // 取得帳號密碼
            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()

            // 登入
            viewModel.login(username, password)
                .subscribe({
                    showToast(it)
                    Log.i(Api.TAG, "doOnNext: current thread: ${Thread.currentThread().name}")
                }, {
                    it.message?.let { message -> showToast(message) }
                })
        }
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}