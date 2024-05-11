package com.josphat.pottercompose.db.di

import androidx.room.Room
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.josphat.pottercompose.db.PotterDB
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {

    @Provides
    @Singleton

    fun provideGson() = Gson()

    @Provides
    @Singleton
    fun provideTyppeConverters(gson: Gson) = Converters(gson)


    @Peovides
    @Singleton
    fun providePotterDB(
        @ApplicationContext context: ApplicationContext,
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
    fun ProvideContractDao(database: PotterDB) = database.characterDao
}