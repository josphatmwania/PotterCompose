package com.josphat.pottercompose.ui.detail

import androidx.lifecycle.ViewModel
import com.josphat.pottercompose.data.repository.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val characterRepo: CharacterRepo
) : ViewModel() {


}