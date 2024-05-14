package com.josphat.pottercompose.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.josphat.pottercompose.db.entities.CharacterEntity


@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characterEntity: List<CharacterEntity>)

    @Query("SELECT * FROM characters_table")
    fun getCharacters(): List<CharacterEntity>

//    @Query("DELETE FROM characters_table WHERE id IN (:ids)")
//    suspend fun deleteCharacters(ids: LIST<String>)
}