package com.geektech.pixabay5.Pixabay.model

data class PixaModel(
    val hits: List<ImageModel>

)

data class ImageModel(
    var LargeImageURL: String
)