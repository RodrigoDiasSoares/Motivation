package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var securityPreferences: SecurityPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(supportActionBar!=null){
            supportActionBar!!.hide()
        }
        btnSalvar.setOnClickListener(this)

        securityPreferences = SecurityPreferences(this)

        verifyName()

    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btnSalvar){
            handleSave()
        }
    }
    private fun handleSave(){
        val name = editNome.text.toString()
        if (name != ""){
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this,"Esvreva um nome", Toast.LENGTH_LONG).show()
        }
    }
    private fun verifyName(){
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}