package com.josphat.pottercompose.di

import com.josphat.pottercompose.data.api.ApiConstants
import com.josphat.pottercompose.data.api.CharaterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): CharaterApi{
        return builder
            .build()
            .create(CharaterApi::class.java)

    }

    /**
     * Create retrofit object
    */
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}