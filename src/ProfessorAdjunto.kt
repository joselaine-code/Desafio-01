class ProfessorAdjunto(
    override val nome: String,
    override val sobrenome: String,
    override val codigoProfessor: Int,
    val quantidadeDeHoras: Int
) : Professor() {
    var curso: Curso? = null
}