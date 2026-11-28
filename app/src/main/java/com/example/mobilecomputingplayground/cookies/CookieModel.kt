package com.example.mobilecomputingplayground.cookies

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class CookieModel @Inject constructor(private val userDao: UserDao) {

  fun getUserScoreFlow(userId: Int): Flow<Int> {
    return userDao.getById(userId).onStart {
      userDao.insertIfMissing(userId)
    }
  }

  suspend fun incrementScoreForUser(userId: Int) {
    userDao.increment(userId)
  }

}
