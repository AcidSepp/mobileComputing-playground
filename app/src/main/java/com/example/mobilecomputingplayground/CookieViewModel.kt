package com.example.mobilecomputingplayground

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import kotlinx.coroutines.launch

class CookieViewModel(application: Application) :
  AndroidViewModel(application) {

  private val userDao = Room.databaseBuilder<AppDatabase>(
    application,
    "cookie_clicker_score_database"
  ).setDriver(AndroidSQLiteDriver()).build().userDao()

  var clicks by mutableIntStateOf(0)
    private set

  init {
    viewModelScope.launch {
      if (userDao.getById(1337) == null) {
        userDao.upsert(
          CookieClickerScore(
            1337,
            0
          )
        )
      }
      clicks = userDao.getById(1337)!!
    }
  }

  fun increment() {
    viewModelScope.launch {
      userDao.increment(1337)
      clicks = userDao.getById(1337)!!
    }
  }

}
