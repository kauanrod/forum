package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.repository.CursoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

  fun buscaPorId(id: Long): Curso {
    return repository.findByIdOrNull(id) ?: throw RuntimeException("ID nao encontrado")
  }
}
