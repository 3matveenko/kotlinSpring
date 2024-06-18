package kz.myproject.kotlinspring.model.dto.product

data class ProductDTO(
    var id:Long = 0L,
    var uuid:String = "",
    var sku:String = "",
    var name:String = "",
    var brand:String = "",
    var count:Int = 0,
    var price:Int = 0,
    var minRemainder:Int = 0,
    var newProduct:Boolean = false,
    var warehouses:MutableList<RemainderDTO>
)
