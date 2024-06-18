package kz.myproject.kotlinspring.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserServise:UserDetailsService{
    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}