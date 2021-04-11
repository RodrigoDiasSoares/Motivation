package com.example.motivation.infra

import android.content.Context

class SecurityPreferences (val context: Context){
    private val sharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key:String, value:String) = sharedPreferences.edit().putString(key,value).apply()

    fun getString(key:String):String = sharedPreferences.getString(key,"") ?:""
}