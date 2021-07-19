package com.aditya.myreactivesearchform.data.remote.response

import com.aditya.myreactivesearchform.data.domain.model.PlaceItem
import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    @field:SerializedName("feature")
    val features: List<PlaceItem>
)