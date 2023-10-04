package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(
  private var topicos: List<Topico> = ArrayList(),
  private val cursoService: CursoService,
  private val usuarioService: UsuarioService
) {
  fun listar(): List<Topico> {
    return topicos
  }

  fun buscarPorId(id: Long): Topico {
    return topicos.stream().filter { topico ->
      topico.id == id
    }.findFirst().get()
  }

  fun cadastrar(dto: NovoTopicoDto) {
    topicos = topicos.plus(
      Topico(
        id = topicos.size.toLong() + 1,
        titulo = dto.titulo,
        mensagem = dto.mensagem,
        curso = cursoService.buscaPorId(dto.idCurso),
        usuario = usuarioService.buscaPorId(dto.idUsuario)
      )
    )
  }
}