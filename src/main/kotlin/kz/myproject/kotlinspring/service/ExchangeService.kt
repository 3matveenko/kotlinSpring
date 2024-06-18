package kz.myproject.kotlinspring.service

import kz.myproject.kotlinspring.controller.ElasticConnecter
import kz.myproject.kotlinspring.model.dto.product.Wrapper0
import kz.myproject.kotlinspring.model.dto.product.Wrapper2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import retrofit2.Call
import java.io.IOException

@Service
class ExchangeService {

    @Autowired
    lateinit var elasticConnecter:ElasticConnecter

    fun startExchange(){
        var listWrapper:MutableList<Wrapper2> = sender()

    }

    fun

    fun sender():MutableList<Wrapper2>{
        var call:Call<Wrapper0> =elasticConnecter.getAllTheProducts()
        var response: retrofit2.Response<Wrapper0> = call.execute()
        if(response.isSuccessful){
            var wrapper0: Wrapper0? = response.body()
            if (wrapper0 != null) {
                return wrapper0.hits.hits
            }
        }
        throw IOException()
    }
}