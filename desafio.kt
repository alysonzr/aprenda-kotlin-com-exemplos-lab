enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int )

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel : Nivel) {

    val inscritos: MutableList<Usuario> = mutableListOf()
    val incritosReading: List<Usuario> = inscritos

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios){
            inscritos.add(usuario)
            println("Aluno ${usuario.nome} Matriculado Com Sucesso!")
        }
    }
    
    fun getAlunos(): String = incritosReading.let { if (it.isNotEmpty()) it.toString() else "Vazia" }
   
    override fun toString(): String {
        return "Lista de Formaçoes e Informaçoes \nFormação $nome, ela contem os seguintes  cursos\n$conteudos,\no seu nivel é $nivel hoje temos ${incritosReading.size} matriculados"
      }

}

fun main() {
    val conteudosBackEnd = mutableListOf(ConteudoEducacional("Java", 50), ConteudoEducacional("Ruby", 60 ), ConteudoEducacional("PHP", 50))
    val conteudosFrontEnd = mutableListOf(ConteudoEducacional("CSS",20), ConteudoEducacional("Angular"), ConteudoEducacional("UX Designer", 40))
    
    var usuario1 = Usuario("Alyson Zancanaro", 26);
    var usuario2 = Usuario("Amanda Bartz", 24);
    var usuario3 = Usuario("Thiago Ferreira", 29);
    
    val formacaoBackEnd = Formacao("Back-end Developer",  conteudosBackEnd, Nivel.INTERMEDIARIO );
    val formacaoFrontEnd = Formacao("Front-end Developer", conteudosFrontEnd, Nivel.BASICO );
    
    formacaoBackEnd.matricular(usuario1, usuario2)
    formacaoFrontEnd.matricular(usuario3)
    print("\n")
    println(formacaoBackEnd)
    print("\n")
    println(formacaoFrontEnd)
 
}
