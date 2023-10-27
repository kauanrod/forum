package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

  fun buscaPorId(id: Long): Usuario {
    return repository.findByIdOrNull(id) ?: throw RuntimeException("ID nao encontrado")
  }
}