package kz.myproject.kotlinspring.config

import kz.myproject.kotlinspring.controller.ElasticConnecter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class RetrofitConfig {

    @Bean
    fun retrofit():Retrofit{
        var logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        var httpClient = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.0.156:9200/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Bean
    fun elasticConnecter(retrofit: Retrofit):ElasticConnecter{
        return retrofit.create(ElasticConnecter::class.java)
    }
}