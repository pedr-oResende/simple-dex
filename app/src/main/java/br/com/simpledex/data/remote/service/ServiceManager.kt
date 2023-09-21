package br.com.simpledex.data.remote.service

import br.com.simpledex.BuildConfig
import br.com.simpledex.data.remote.converter.ToStringConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class ServiceManager {

    private val retrofit: Retrofit
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }

            return Retrofit.Builder()
                .baseUrl(API.baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ToStringConverterFactory())
                .build()
        }

    fun <T> create(cls: Class<T>): T = retrofit.create(cls)
}