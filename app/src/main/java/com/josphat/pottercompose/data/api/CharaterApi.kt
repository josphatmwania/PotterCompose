package com.josphat.pottercompose.data.api

import com.josphat.pottercompose.data.api.model.Character
import retrofit2.http.GET

interface CharaterApi {
    @GET(ApiConstants.END_POINTS)
    suspend fun getCharacter() : List<Character>
}