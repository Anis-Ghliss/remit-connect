package com.example.remitconnect.di

import com.example.remitconnect.utils.Constants

import com.example.remitconnect.data.remote.RemitConnectApi
import com.example.remitconnect.data.repo.CountriesRepositoryImpl
import com.example.remitconnect.data.repo.RecipientRepositoryImpl
import com.example.remitconnect.data.repo.WalletRepositoryImpl
import com.example.remitconnect.domain.repo.CountriesRepository
import com.example.remitconnect.domain.repo.RecipientRepository
import com.example.remitconnect.domain.repo.WalletRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMonecoApi(): RemitConnectApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemitConnectApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipinetsRepository(api: RemitConnectApi): RecipientRepository {
        return RecipientRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCountiresRepository(api: RemitConnectApi): CountriesRepository {
        return CountriesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideWalletRepository(api: RemitConnectApi): WalletRepository {
        return WalletRepositoryImpl(api)
    }

}