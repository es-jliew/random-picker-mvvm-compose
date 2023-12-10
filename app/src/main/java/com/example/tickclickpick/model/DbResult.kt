package com.example.tickclickpick.model

sealed class DbResult {
    data object Success : DbResult()
    data class Failure(val errorMessage: String) : DbResult()
}