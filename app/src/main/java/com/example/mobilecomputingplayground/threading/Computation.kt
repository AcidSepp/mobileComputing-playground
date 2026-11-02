package com.example.mobilecomputingplayground.threading

import android.util.Log

class Computation(val computationViewModel: ComputationViewModel) {

  fun startComputation() {
    repeat(Int.MAX_VALUE) {
      repeat(Int.MAX_VALUE) {
        Log.i(
          "test",
          "computing"
        )
        computationViewModel.result++
      }
    }
  }
}
