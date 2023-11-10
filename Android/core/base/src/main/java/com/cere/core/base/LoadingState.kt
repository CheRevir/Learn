package com.cere.core.base

sealed class LoadingState {
    data class SUCCESS(val message: String? = null) : LoadingState()
    data class FAIL(val message: String? = null) : LoadingState()
    data class LOADING(val progress: Progress, val message: String? = null) : LoadingState()
}