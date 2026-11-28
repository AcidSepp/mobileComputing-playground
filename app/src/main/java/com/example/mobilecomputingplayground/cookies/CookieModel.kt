package com.example.mobilecomputingplayground.cookies

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CookieModel @Inject constructor(private val userDao: UserDao) {

  val userScore: Flow<Int> = userDao.getById(1337)

  suspend fun incrementScoreForUser(userId: Int) {
    userDao.increment(userId)
  }

}
