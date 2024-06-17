package kz.myproject.kotlinspring.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,
    @Column(name = "email")
    var email:String,
    @Column(name = "password")
    var pwd:String

):UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String = pwd

    override fun getUsername(): String = email
}


