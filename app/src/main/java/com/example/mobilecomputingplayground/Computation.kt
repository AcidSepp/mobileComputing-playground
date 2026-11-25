package com.example.mobilecomputingplayground

import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

class Computation(private val computationViewModel: ComputationViewModel) {

  @OptIn(ExperimentalAtomicApi::class)
  val isAlreadyRunning = AtomicBoolean(false)

  @OptIn(ExperimentalAtomicApi::class)
  suspend fun startComputation() {
    if (isAlreadyRunning.compareAndSet(
        false,
        true
      )
    ) {
      for (i in 0 until Int.MAX_VALUE) {
        for (j in 0 until Int.MAX_VALUE) {
          computationViewModel.result += (i + j)
        }
      }
      isAlreadyRunning.compareAndSet(
        true,
        false
      )
    }
  }

}
