package com.geektech.pixabay5

import android.app.Application
import com.geektech.pixabay5.Pixabay.model.PixaApi
import com.geektech.pixabay5.Pixabay.model.RetrofitService
import retrofit2.Retrofit

class App: Application() {
    companion object{
    lateinit var  api :PixaApi}

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().getApi()
    }
}
