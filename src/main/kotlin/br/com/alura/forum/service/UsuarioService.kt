package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository): UserDetailsService {

  fun buscaPorId(id: Long): Usuario {
    return repository.findByIdOrNull(id) ?: throw RuntimeException("ID nao encontrado")
  }
  
  override fun loadUserByUsername(username: String?): UserDetail {
    val user = repository.findByEmail(username) ?: throw RuntimeException("Login nao autenticado")
    return UserDetail(user)
  }
  
}