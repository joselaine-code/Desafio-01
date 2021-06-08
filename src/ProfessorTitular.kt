class ProfessorTitular(
    override val nome: String,
    override val sobrenome: String,
    override val codigoProfessor: Int,
    val especialidade: String
) : Professor() {
    var curso: Curso? = null
}