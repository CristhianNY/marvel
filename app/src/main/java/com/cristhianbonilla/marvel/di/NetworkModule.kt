package com.cristhianbonilla.marvel.di

import android.content.Context
import com.cristhianbonilla.marvel.BuildConfig
import com.cristhianbonilla.marvel.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val endpointToAvoidToken = "login"
    private val singUp = "signup"

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(NetworkInterceptor.httpLogging())

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val requestBuilder = original.newBuilder().url(originalHttpUrl)

            if (originalHttpUrl.toString()
                .contains(singUp)
            ) {
            } else {
                if (!originalHttpUrl.toString()
                    .contains(endpointToAvoidToken)
                ) {
                    requestBuilder.addHeader(
                        "Authorization",
                        "Bearer "
                    )
                }
            }

            requestBuilder.header("Content-Type", "application/json")
            requestBuilder.header("Accept", "application/json")

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return httpClient.build()
    }
}
