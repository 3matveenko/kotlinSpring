package kz.myproject.kotlinspring.model.dto.count

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Query(
    var size:Int,
    var query:Mach
)
