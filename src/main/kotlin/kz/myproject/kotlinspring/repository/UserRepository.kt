package kz.myproject.kotlinspring.repository

import kz.myproject.kotlinspring.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository:JpaRepository<User,Long>{

 fun findUserByEmail(email:String): Optional<User>
}