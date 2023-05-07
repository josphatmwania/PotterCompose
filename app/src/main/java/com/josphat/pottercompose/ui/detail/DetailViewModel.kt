package com.josphat.pottercompose.ui.detail

import androidx.lifecycle.ViewModel
import com.josphat.pottercompose.data.repository.CharacterRepo
import javax.inject.Inject

class DetailViewModel  @Inject constructor(
    private val characterRepo: CharacterRepo
) : ViewModel() {
}