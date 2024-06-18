package kz.myproject.kotlinspring.model.dto.count

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Uuid(
    var uuid:String
)
