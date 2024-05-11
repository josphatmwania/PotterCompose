package com.josphat.pottercompose.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 2,
    exportSchema = true

)

@TypeConverters(Converters::Class)
abstract class PotterDB : RoomDatabase(){
    abstract val characterDao: CharacterDao
}