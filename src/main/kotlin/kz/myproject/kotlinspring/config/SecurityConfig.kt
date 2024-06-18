package kz.myproject.kotlinspring.config

import kz.myproject.kotlinspring.service.UserServise
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun securityService():UserServise{
        return UserServise()
    }

    @Bean
    fun passwordEncoder():PasswordEncoder{
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        val authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder::class.java)

        authenticationManagerBuilder
            .userDetailsService<UserDetailsService>(securityService())
            .passwordEncoder(passwordEncoder())



        http.formLogin { formLogin: FormLoginConfigurer<HttpSecurity?> ->
            formLogin
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .loginProcessingUrl("/enter")
                .usernameParameter("user_login")
                .passwordParameter("user_password")
        }

        http.logout { formLogout: LogoutConfigurer<HttpSecurity?> ->
            formLogout
                .logoutUrl("/exit")
                .logoutSuccessUrl("/login")
        }

        http.authorizeHttpRequests { authorize ->
            authorize.anyRequest().permitAll()
        }

        return http.build()
    }
}