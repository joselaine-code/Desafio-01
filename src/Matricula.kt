import java.text.SimpleDateFormat
import java.util.*

class Matricula(
    aluno: Aluno?,
    curso: Curso?,
) {
    var data = ""

    init {
        val format = SimpleDateFormat("dd/M/yyyy")
        data = format.format(Date())
    }
}