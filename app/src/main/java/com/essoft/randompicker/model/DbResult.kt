package com.essoft.randompicker.model

sealed class DbResult {
    data object Success : DbResult()
    data class Failure(val errorMessage: String) : DbResult()
}