package com.geektech.pixabay5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.geektech.pixabay5.Pixabay.model.ImageModel
import com.geektech.pixabay5.Pixabay.model.PixaModel
import com.geektech.pixabay5.databinding.ActivityMainBinding
import com.geektech.pixabay5.databinding.ItemLayoutBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var photoAdapter = PhotoAdapter(arrayListOf())

    var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.requestByImage(++page)
                }
            }
        })
    }

    private fun initClickers() {
        with(binding) {
            changePage.setOnClickListener {
                requestByImage(++page)
            }
            getImageBtn.setOnClickListener {
                page = 1
                requestByImage(page)
            }
        }
    }

    private fun ActivityMainBinding.requestByImage(page: Int) {
        App.api.getImages(keyWord = photoEd.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>,
                ) {
                    response.body()?.hits?.let { listImageModel ->
                        listImageModel.forEach {
                            photoAdapter.addImage(it)
                        }

                    }
                    binding.recyclerView.adapter = photoAdapter

                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
    }
}