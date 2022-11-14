package com.geektech.pixabay5.Pixabay.model

import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")

    fun getImages(
        @Query("key") key: String = "30922676-9fe360b9f8d6373d3d0dc34ec",
        @Query("q") keyWord: String,
    @Query("page") page: Int = 1,
        @Query("per_page") perPage:  Int = 5,
    ): retrofit2.Call<PixaModel>

}
