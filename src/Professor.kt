abstract class Professor {
    abstract val nome: String
    abstract val sobrenome: String
    val tempoDeCasa: Int = 0
    abstract val codigoProfessor: Int

    override fun equals(other: Any?): Boolean {
        val otherProfessor = other as? Professor
        return when (other) {
            is Professor -> {
                this.codigoProfessor == otherProfessor?.codigoProfessor
            }
            else -> {
                super.equals(other)
            }
        }
    }
}