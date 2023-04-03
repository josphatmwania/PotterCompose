package com.josphat.pottercompose.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wand(
    @Json(name = "core")
    val core: String,
    @Json(name = "length")
    val length: Int,
    @Json(name = "wood")
    val wood: String
)