class Aluno(
    val nome: String,
    val sobrenome: String,
    val codigoAluno: Int
) {
    var curso: Curso? = null

    override fun equals(other: Any?): Boolean {
        val otherAluno = other as? Aluno
        return when (other) {
            is Aluno -> {
                this.codigoAluno == otherAluno?.codigoAluno
            }
            else -> {
                super.equals(other)
            }
        }
    }
}