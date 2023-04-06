package com.feliipessantos.listou.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feliipessantos.listou.R
import com.feliipessantos.listou.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btAdd.setOnClickListener {
            val dialogAdd = DialogAdd()
            dialogAdd.show(supportFragmentManager, "")
        }
    }
}