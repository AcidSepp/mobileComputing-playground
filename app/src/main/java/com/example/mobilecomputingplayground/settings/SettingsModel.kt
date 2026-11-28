package com.example.mobilecomputingplayground.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val volumePreferenceKey = floatPreferencesKey("volume")

@Singleton
class SettingsModel @Inject constructor(
  private val dataStore: DataStore<Preferences>,
) {

  val volume: Flow<Float> = dataStore.data.map { preferences ->
    preferences[volumePreferenceKey] ?: 1.0f
  }

  suspend fun changeSliderValue(value: Float) {
    dataStore.edit {
      it[volumePreferenceKey] = value
    }
  }
}
