package kz.myproject.kotlinspring.controller

import kz.myproject.kotlinspring.model.dto.count.Query
import kz.myproject.kotlinspring.model.dto.product.Wrapper0
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface ElasticConnecter {

    @GET("/warehouse/item/_search")
    fun getAllTheCompanies():Call<Wrapper0>

    @GET("/remains/item/_search/?size=10000&pretty=1&filter_path=hits.hits._source")
    fun getAllTheProducts():Call<Wrapper0>

    @Headers("Content-Type: application:json")
    @POST("/product/item/_search")
    fun getPriceByUuid(@Body query: Query)
}