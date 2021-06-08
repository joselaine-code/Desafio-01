fun main() {
    val sistema = DigitalHouseManager()

    sistema.registrarProfessorTitular("Cesar", "Rodrigues", 3222, "Android")
    sistema.registrarProfessorTitular("Ana", "Santos", 3258, "FullStack")

    sistema.registrarProfessorAdjunto("Eduardo", "Misina", 1234, 50)
    sistema.registrarProfessorAdjunto("Alberto", "Prudente", 1568, 40)

    sistema.registrarCurso("Full Stack", 20001, 3)
    sistema.registrarCurso("Android", 20002, 2)

    sistema.matricularAluno("Joselaine", "Santos", 2222)
    sistema.matricularAluno("Camila", "Bianco", 1235)
    sistema.matricularAluno("Juliana", "Rodrigues", 1236)
    sistema.matricularAluno("Vanessa", "Rosa", 1237)
    sistema.matricularAluno("Pedro", "Ruiz", 1238)

    sistema.matricularEmCurso(1236,20001)
    sistema.matricularEmCurso(1237,20001)

    sistema.matricularEmCurso(2222,20002)
    sistema.matricularEmCurso(1235,20002)
    sistema.matricularEmCurso(1238,20002)

    sistema.mostrarInfoAluno(1237)
}