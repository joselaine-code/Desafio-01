class Curso(
    val nome: String,
    val codigoCurso: Int,
    val quantidadeMaxima: Int,
) {

    val listaDeAlunos = mutableSetOf<Aluno>()
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    fun adicionarAluno(aluno: Aluno): Boolean {
        return if (listaDeAlunos.size < quantidadeMaxima) {
            listaDeAlunos.add(aluno)
            aluno.curso = this
            println("Aluno(a) ${aluno.nome} adicionado(a) ao curso $nome")
            true
        } else {
            println("Não há vagas disponíveis no curso $nome")
            false
        }
    }

    fun excluirAluno(aluno: Aluno) {
        if (listaDeAlunos.contains(aluno)) {
            listaDeAlunos.remove(aluno)
        } else {
            println("Aluno não encontrado")
        }
    }

    override fun equals(other: Any?): Boolean {
        val otherCurso = other as? Curso
        return when (other) {
            is Curso -> {
                this.codigoCurso == otherCurso?.codigoCurso
            }
            else -> {
                super.equals(other)
            }
        }
    }

    fun mostrarDetalhes(){
        println("Curso $nome\n" +
                "Código do Curso: $codigoCurso\n" +
                "Quantidade máxima de alunos: $quantidadeMaxima")
        if (professorAdjunto != null){
            println("Professor Adjunto: ${professorAdjunto?.nome} ${professorAdjunto?.sobrenome}")
        } else {
            println("Sem Professor Adjunto")
        }
        if (professorTitular != null){
            println("Professor Titular: ${professorTitular?.nome} ${professorTitular?.sobrenome}")
        } else {
            println("Sem Professor Titular")
        }
    }
}