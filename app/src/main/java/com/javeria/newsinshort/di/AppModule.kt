package com.javeria.newsinshort.di

import com.javeria.newsinshort.AppConstants.BASE_URL
import com.javeria.newsinshort.data.repository.NewsRepository
import com.javeria.newsinshort.data.repository.remote.api.ApiService
import com.javeria.newsinshort.data.repository.remote.datasource.NewsDataSource
import com.javeria.newsinshort.data.repository.remote.datasource.NewsDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().baseUrl(BASE_URL).client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNewDataSource(apiService: ApiService): NewsDataSource {
        return NewsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(dataSource: NewsDataSource): NewsRepository {
        return NewsRepository(dataSource)
    }
}