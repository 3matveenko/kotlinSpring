package kz.myproject.kotlinspring.controller

import kz.myproject.kotlinspring.service.ExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.logging.Level
import java.util.logging.Logger

@Controller("/")
class Controller {

    private val logger: Logger = Logger.getLogger(Controller::class.java.name)
    @Autowired
    lateinit var exchangeService:ExchangeService

    @GetMapping("/")
    fun doit():ResponseEntity<String>{
        logger.log(Level.INFO,"start method doit")
        exchangeService.startExchange()
    }
}