package kz.myproject.kotlinspring.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Getter
import lombok.Setter
import java.time.LocalDate

@Getter
@Setter
@Entity
data class Task(

    @Id
   var id:Long,
    var title:String,
    var dateEnd:LocalDate,
    var switch:Boolean
)
