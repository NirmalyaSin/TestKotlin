package com.testKotlin.retrofit

import com.google.gson.GsonBuilder
import com.utils.Prefs
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class RetrofitClient {


    companion object {
        private var retrofit: Retrofit? = null
        var BASE_URL = "https://reqres.in/api/"
        fun getClient(): ApiInterface {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient(false))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit!!.create(ApiInterface::class.java)
        }

        fun getClient(isSignup: Boolean): ApiInterface {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient(isSignup))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit!!.create(ApiInterface::class.java)
        }

        private fun getHttpClient(isSignUp: Boolean): OkHttpClient? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
                /*.cache(
                    Cache(
                        CreditFixerApplication.getInstance().getCacheDir(),
                        10 * 1024 * 1024
                    )
                )*/ // 10 MB
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
            if (!isSignUp) {
                builder.addNetworkInterceptor(AddHeaderInterceptor())
            }
            return builder.build()
        }

        private class AddHeaderInterceptor : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val builder: Request.Builder = chain.request().newBuilder()
                builder.addHeader("Accept", "application/json")
                val prefs: Prefs = Prefs.getInstance()
                val accessToken: String = prefs.getString(Prefs.PREFS_KEY_ACCESS_TOKEN)
                if (!accessToken.isEmpty()) {
//                CommonMethods.makeLog("Authorization", accessToken)
                    builder.addHeader("Authorization", "Bearer $accessToken")
                }
                return chain.proceed(builder.build())
            }
        }

    }


    /*fun getEditBillClient(): ApiInterface? {
        com.creditfixer.api.retrofit.RetrofitApiClient.retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpClient(false))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return com.creditfixer.api.retrofit.RetrofitApiClient.retrofit.create(ApiInterface::class.java)
    }*/

   }