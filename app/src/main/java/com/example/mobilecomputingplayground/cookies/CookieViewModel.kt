package com.example.mobilecomputingplayground.cookies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CookieViewModel @Inject constructor(val cookieModel: CookieModel) :
  ViewModel() {

  var clicks = cookieModel.userScore.stateIn(
    viewModelScope,
    SharingStarted.WhileSubscribed(),
    0
  )

  var user by mutableIntStateOf(1337)
    private set


  fun increment() {
    viewModelScope.launch {
      cookieModel.incrementScoreForUser(user)
    }
  }

  fun switchUser(newUserId: Int) {
    user = newUserId
  }
}
