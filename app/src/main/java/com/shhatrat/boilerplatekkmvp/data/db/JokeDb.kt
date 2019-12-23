package com.shhatrat.boilerplatekkmvp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shhatrat.boilerplatekkmvp.data.db.model.JokeTable

@Database(entities = [JokeTable::class], version = 1, exportSchema = false)
public abstract class JokeDb : RoomDatabase() {

    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile
        private var INSTANCE: JokeDb? = null

        fun getDatabase(context: Context): JokeDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDb::class.java,
                    "joke"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}