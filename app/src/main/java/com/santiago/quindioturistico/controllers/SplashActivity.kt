package com.santiago.quindioturistico.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.santiago.quindioturistico.MenuActivity
import com.santiago.quindioturistico.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startTimer()
    }
    fun startTimer() {
        object :  CountDownTimer(3000,1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent  =  Intent(applicationContext, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}