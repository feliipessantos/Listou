package com.feliipessantos.listou.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.feliipessantos.listou.R
import com.feliipessantos.listou.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setupViewSwitcher()
        _binding.btLogin.setOnClickListener {
            validateLogin()
        }

        _binding.BtRegister.setOnClickListener {
            validateRegister()
        }
    }

    private fun validateRegister() {
        if (_binding.TextInputRegisterName.text.isNullOrEmpty()) {
            _binding.EditName.apply {
                isHelperTextEnabled = true
                helperText = "Please fill your Name"
                boxStrokeColor = getColor(R.color.red)
            }
        }
        if (_binding.TextInputRegisterEmail.text.isNullOrEmpty()) {
            _binding.EditEmailRegister.apply {
                isHelperTextEnabled = true
                helperText = "Please fill your email"
                boxStrokeColor = getColor(R.color.red)
            }
        }
        if (_binding.TextInputRegisterPass.text.toString().length < 6) {
            _binding.EditPasswordRegister.apply {
                isHelperTextEnabled = true
                helperText = "Your password must have min 6 characters"
                boxStrokeColor = getColor(R.color.red)
            }
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateLogin() {
        if (_binding.TextInputEmail.text.isNullOrEmpty()) {
            _binding.EditEmail.apply {
                isHelperTextEnabled = true
                helperText = "Please fill your email"
                boxStrokeColor = getColor(R.color.red)
            }
        }
        if (_binding.TextInputPass.text.isNullOrEmpty()) {
            _binding.EditPassword.apply {
                isHelperTextEnabled = true
                helperText = "Please fill your password"
                boxStrokeColor = getColor(R.color.red)
            }
        } else {
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