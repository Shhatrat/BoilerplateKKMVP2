package com.shhatrat.boilerplatekkmvp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shhatrat.boilerplatekkmvp.data.db.model.JokeTable
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface JokeDao {

    @Query("SELECT * from joke_table")
    fun getJoke(): Observable<List<JokeTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: JokeTable): Completable

    @Query("DELETE FROM joke_table")
    fun deleteAll(): Completable
}