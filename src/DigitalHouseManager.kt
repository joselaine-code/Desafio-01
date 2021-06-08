class DigitalHouseManager {
    val listaDeAlunos = mutableSetOf<Aluno>()
    val listaDeProfessores = mutableSetOf<Professor>()
    val listaDeCursos = mutableSetOf<Curso>()
    val listaDeMatricula = mutableSetOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaxima: Int) {
        val cursoExistente: Curso? = listaDeCursos.find { it.codigoCurso == codigoCurso }
        if (cursoExistente != null) {
            println("Código do curso já existe.")
        } else {
            val curso = Curso(nome, codigoCurso, quantidadeMaxima)
            listaDeCursos.add(curso)
            println("Curso $nome adiconado.")
        }
    }

    fun excluirCurso(codigoCurso: Int) {
        val cursoEscolhido: Curso? = listaDeCursos.find { it.codigoCurso == codigoCurso }
        if (cursoEscolhido != null) {
            listaDeCursos.remove(cursoEscolhido)
            println("${cursoEscolhido.nome} removido com sucesso!")
        } else {
            println("Curso não localizado")
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professor = ProfessorAdjunto(nome, sobrenome, codigoProfessor, quantidadeDeHoras)
        listaDeProfessores.add(professor)
        println("Professor(a) Adjunto(a) ${professor.nome} ${professor.sobrenome} adicionado(a).")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professor = ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade)
        listaDeProfessores.add(professor)
        println("Professor(a) Titular ${professor.nome} ${professor.sobrenome} adicionado(a).")
    }

    fun excluirProfessor(codigoProfessor: Int) {
        val professorEscolhido: Professor? = listaDeProfessores.find { it.codigoProfessor == codigoProfessor }
        if (professorEscolhido != null) {
            listaDeProfessores.remove(professorEscolhido)
            println("${professorEscolhido.nome} removido(a).")
        } else {
            println("Professor(a) não localizado(a).")
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val alunoMatriculado: Aluno? = listaDeAlunos.find { it.codigoAluno == codigoAluno }
        if (alunoMatriculado != null) {
            println("Aluno já está matriculado.")
        } else {
            val aluno = Aluno(nome, sobrenome, codigoAluno)
            listaDeAlunos.add(aluno)
            println("Matrícula realizada.")
        }
    }

    fun matricularEmCurso(codigoAluno: Int, codigoCurso: Int) {
        val cursoEscolhido: Curso? = listaDeCursos.find { it.codigoCurso == codigoCurso }
        val alunoEscolhido: Aluno? = listaDeAlunos.find { it.codigoAluno == codigoAluno }

        when {
            cursoEscolhido == null -> {
                println("Curso não localizado.")
            }
            alunoEscolhido == null -> {
                println("Aluno não localizado.")
            }
            else -> {
                val matricula = Matricula(alunoEscolhido, cursoEscolhido)
                listaDeMatricula.add(matricula)
                alunoEscolhido?.let { cursoEscolhido?.adicionarAluno(it) }
            }
        }

    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val professorTitular: ProfessorTitular? =
            listaDeProfessores.find { it.codigoProfessor == codigoProfessorTitular } as ProfessorTitular?
        val professorAdjunto: ProfessorAdjunto? =
            listaDeProfessores.find { it.codigoProfessor == codigoProfessorAdjunto } as ProfessorAdjunto?
        val cursoEscolhido: Curso? = listaDeCursos.find { it.codigoCurso == codigoCurso }
        when {
            cursoEscolhido == null -> {
                println("Curso não localizado.")
            }
            professorTitular == null -> {
                println("Professor(a) Titular não localizado(a).")
            }
            professorAdjunto == null -> {
                println("Professor(a) Adjunto(a) não localizado(a).")
            }
            else -> {
                cursoEscolhido.professorTitular = professorTitular
                cursoEscolhido.professorAdjunto = professorAdjunto
                println("Professores alocados com sucesso.")
            }
        }
    }

    fun localizarCurso(codigoCurso: Int) {
        val cursoEscolhido: Curso? = listaDeCursos.find { it.codigoCurso == codigoCurso }
        if (cursoEscolhido != null) {
            println(
                "Curso ${cursoEscolhido.nome}\n" +
                        "Quantidade máxima de alunos: ${cursoEscolhido.quantidadeMaxima}\n" +
                        "Quantidades de alunos matriculados: ${cursoEscolhido.listaDeAlunos.size}"
            )
            if (cursoEscolhido.professorAdjunto != null) {
                println("Professor Adjunto: ${cursoEscolhido.professorAdjunto?.nome} ${cursoEscolhido.professorAdjunto?.sobrenome}")
            } else {
                println("Sem Professor Adjunto")
            }
            if (cursoEscolhido.professorTitular != null) {
                println("Professor Titular: ${cursoEscolhido.professorTitular?.nome} ${cursoEscolhido.professorTitular?.sobrenome}")
            } else {
                println("Sem Professor Titular")
            }
        } else {
            println("Curso não localizado")
        }
    }

    fun mostrarInfoAluno(codigoAluno: Int){
        val alunoEscolhido: Aluno? = listaDeAlunos.find { it.codigoAluno == codigoAluno }
        if (alunoEscolhido != null){
            println("Aluno(a): ${alunoEscolhido.nome} ${alunoEscolhido.sobrenome}" )
                if (alunoEscolhido.curso != null){
                    println("Curso: ${alunoEscolhido.curso?.nome}")
                } else {
                    println("Não está matriculado em nenhum curso")
                }
        } else {
            println("Aluno(a) não encontrado.")
        }
    }
}

