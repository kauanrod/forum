package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {
  init {
    val usuario = Usuario(
      id = 1,
      nome = "Kauan",
      email = "kauanrod@hotmail.com"
    )
    usuarios = Arrays.asList(usuario)
  }

  fun buscaPorId(id: Long): Usuario {
    return usuarios.stream().filter { usuario ->
      usuario.id == id
    }.findFirst().get()
  }
}