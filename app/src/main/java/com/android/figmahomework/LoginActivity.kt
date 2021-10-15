package com.android.figmahomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.figmahomework.FadingImageView.FadeSide
import android.view.View
import com.android.figmahomework.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var binding : ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.let {
            it.ivBackground.apply {
                setEdgeLength(100)
                setFadeDirection(FadeSide.UP_SIDE)
                setEdgeLength(200)
                setFadeDirection(FadeSide.DOWN_SIDE)
            }




            it.btnGuest.setOnClickListener(this@LoginActivity)
            it.btnSignIn.setOnClickListener(this@LoginActivity)
            it.btnSignInFacebook.setOnClickListener(this@LoginActivity)
            it.btnSignUp.setOnClickListener(this@LoginActivity)
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}