package com.josphat.pottercompose.db.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.josphat.pottercompose.db.PotterDB
import com.josphat.pottercompose.db.converters.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.InstallIn;






@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton

    fun provideGson() = Gson()

    @Provides
    @Singleton
    fun provideTyppeConverters(gson: Gson) = Converters(gson)


    @Provides
    @Singleton
    fun providePotterDB(
        @ApplicationContext context: Context,
        converters: Converters
    ) : PotterDB {
        return Room.databaseBuilder(context.applicationContext,
            PotterDB::class.java,
            "PotterDB")
            .fallbackToDestructiveMigration()
            .addTypeConverter(converters)
            .build()
    }

    @Provides
    @Singleton
    fun provideContractDao(database: PotterDB) = database.characterDao
}