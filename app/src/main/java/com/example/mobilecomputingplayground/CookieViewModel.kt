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

  private val db = Room.databaseBuilder<AppDatabase>(
    application,
    "cookie_clicker_score_database"
  ).setDriver(AndroidSQLiteDriver()).build()

  private val userDao = db.userDao()

  init {
    viewModelScope.launch {
      val byId = userDao.getById(1337)
      if (byId.isEmpty()) {
        val initialScore = CookieClickerScore(
          1337,
          0
        )
        userDao.upsert(initialScore)
        val score = userDao.getById(1337).first()
        clicks = score.score
      } else {
        val score = byId.first()
        clicks = score.score
      }
    }
  }

  var clicks by mutableIntStateOf(0)
    private set


  fun increment() {
    val score = CookieClickerScore(
      1337,
      ++clicks
    )
    viewModelScope.launch {
      userDao.upsert(score)
    }
  }

}
