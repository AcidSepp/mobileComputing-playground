@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.mobilecomputingplayground.cookies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CookieViewModel @Inject constructor(val cookieModel: CookieModel) :
  ViewModel() {

  val userId = MutableStateFlow(1337)

  var clicks: StateFlow<Int> = userId.flatMapLatest {
    cookieModel.getUserScoreFlow(it)
  }.stateIn(
    viewModelScope,
    SharingStarted.WhileSubscribed(),
    0
  )

  fun increment() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        cookieModel.incrementScoreForUser(userId.value)
      }
    }
  }

  fun changeUser(newUserId: Int) {
    userId.value = newUserId
  }
}
