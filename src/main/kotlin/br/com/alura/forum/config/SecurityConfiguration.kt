package br.com.alura.forum.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http.invoke {
      csrf { disable() }
      authorizeRequests {
        authorize(HttpMethod.GET,"/topicos", hasAuthority("LEITURA_ESCRITA"))
        authorize(HttpMethod.POST,"/topicos", hasAuthority("LEITURA_ESCRITA"))
        authorize(HttpMethod.PUT,"/topicos", hasAuthority("LEITURA_ESCRITA"))
        authorize(HttpMethod.DELETE,"/topicos", hasAuthority("LEITURA_ESCRITA"))
        
        authorize(anyRequest, authenticated)
      }
      sessionManagement {
        sessionCreationPolicy = SessionCreationPolicy.STATELESS
      }
      headers { frameOptions { disable() } }
      httpBasic { }
    }
    return http.build()
  }
  
  @Bean
  fun encoder(): PasswordEncoder = BCryptPasswordEncoder()
}