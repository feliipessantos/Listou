package com.feliipessantos.listou.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.feliipessantos.listou.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setupViewSwitcher()
        _binding.btLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewSwitcher() {
        val viewSwitcher = _binding.viewSwitcher
        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        viewSwitcher.inAnimation = inAnim

        val out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        viewSwitcher.outAnimation = out

        _binding.BtSwitchRegisterView.setOnClickListener {
            viewSwitcher.showNext()
        }

        _binding.btArrowLeft.setOnClickListener {
            viewSwitcher.showNext()
        }
    }
}