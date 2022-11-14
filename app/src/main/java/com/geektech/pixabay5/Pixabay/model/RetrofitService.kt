package com.geektech.pixabay5.Pixabay.model

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    val api(): PixaApi{
        return retrofit.create(PixaApi::class.java)
    }

    fun getApi(): PixaApi {
    }
}