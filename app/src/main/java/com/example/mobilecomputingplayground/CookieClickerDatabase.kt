package com.example.mobilecomputingplayground

import androidx.room3.ColumnInfo
import androidx.room3.Dao
import androidx.room3.Database
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import androidx.room3.Query
import androidx.room3.RoomDatabase
import androidx.room3.Upsert

@Entity(tableName = "cookie_clicker_score")
data class CookieClickerScore(
  @PrimaryKey val uid: Int,
  @ColumnInfo(name = "score") val score: Int,
)

@Dao
interface UserDao {
  @Query("SELECT * FROM cookie_clicker_score WHERE uid=:uid")
  suspend fun getById(uid: Int): List<CookieClickerScore>

  @Upsert
  suspend fun upsert(cookieClickerScores: CookieClickerScore)
}

@Database(
  entities = [CookieClickerScore::class],
  version = 1
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao
}
