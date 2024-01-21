package com.essoft.randompicker.db

import android.content.Context
import com.essoft.randompicker.model.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.exception.DbException
import io.objectbox.exception.FileCorruptException

/**
 * Singleton to keep BoxStore reference and provide current list of Recipes Objects.
 */
object ObjectBox {
    lateinit var boxStore: BoxStore
        private set

    /**
     * If building the boxStore failed, contains the thrown error message.
     */
    private var dbExceptionMessage: String? = null

    fun init(context: Context) {
        boxStore = try {
            MyObjectBox.builder()
                .androidContext(context.applicationContext)
                .build()
        } catch (e: DbException) {
            if (e.javaClass == DbException::class.java || e is FileCorruptException) {
                dbExceptionMessage = e.toString()
                return
            } else {
                // Failed to build BoxStore due to developer error.
                throw e
            }
        }
    }
}