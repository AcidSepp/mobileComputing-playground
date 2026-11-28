package com.example.mobilecomputingplayground.cookies

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CookieModule {
  @Provides
  @Singleton
  fun provideDao(@ApplicationContext context: Context): UserDao {
    return Room.databaseBuilder<AppDatabase>(
      context,
      "cookie_clicker_score_database"
    ).setDriver(AndroidSQLiteDriver()).build().userDao()
  }
}
