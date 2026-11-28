package com.example.mobilecomputingplayground.cookies

import androidx.room3.ColumnInfo
import androidx.room3.Dao
import androidx.room3.Database
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import androidx.room3.Query
import androidx.room3.RoomDatabase
import androidx.room3.Upsert
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "cookie_clicker_score")
data class CookieClickerScore(
  @PrimaryKey val uid: Int,
  @ColumnInfo(name = "score") val score: Int,
)

@Dao
interface UserDao {
  @Query("SELECT score FROM cookie_clicker_score WHERE uid=:uid")
  fun getById(uid: Int): Flow<Int>

  @Upsert
  suspend fun upsert(cookieClickerScores: CookieClickerScore)

  @Query("UPDATE cookie_clicker_score SET score = score + 1 WHERE uid=:uid")
  suspend fun increment(uid: Int)
}

@Database(
  entities = [CookieClickerScore::class],
  version = 1
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao
}
