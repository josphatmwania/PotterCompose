package com.josphat.pottercompose.data.repository

import com.josphat.pottercompose.data.api.CharaterApi
import com.josphat.pottercompose.data.api.model.Character
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val charaterApi: CharaterApi
){

    suspend fun getCharacters():List<Character>{
        return charaterApi.getCharacter()
    }
}