import java.util.*

enum class TipoGaiola {
    SAVANA,
    AQUARIO,
    FLORESTA,
    OUTRO
}

class Animal(
    val nome: String,
    val origem: String,
    val dieta: String,
    val tipoGaiola: TipoGaiola,
    val localizacao: String
) {
    override fun toString(): String {
        return "nome: $nome\n" +
                "Origem: $origem\n" +
                "Dieta: $dieta\n" +
                "Tipo de Gaiola: $tipoGaiola\n" +
                "Localização na Sela: $localizacao"
    }
}

class Zoologico {
    private val animais: MutableList<Animal> = mutableListOf()

    fun adicionarAnimal(animal: Animal) {
        animais.add(animal)
    }

    fun listarAnimais() {
        println("Animais do Zoológico:")
        for (animal in animais) {
            println(animal)
            println()
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val zoo = Zoologico()

    val leao = Animal("Leão", "África", "Carnívoro", TipoGaiola.SAVANA, "Sela 1")
    val tigre = Animal("Tigre", "Ásia", "Carnívoro", TipoGaiola.SAVANA, "Sela 2")
    val golfinho = Animal("Golfinho", "Oceano", "Peixe", TipoGaiola.AQUARIO, "Aquário Principal")

    zoo.adicionarAnimal(leao)
    zoo.adicionarAnimal(tigre)
    zoo.adicionarAnimal(golfinho)

    var opcao: Int

    do {
        println("\nSelecione uma opção:")
        println("1 - Cadastrar novo animal")
        println("2 - Listar animais já cadastrados")
        println("0 - Sair")
        print("Opção: ")

        opcao = scanner.nextInt()

        when (opcao) {
            1 -> {
                println("\nCadastrar Novo Animal:")
                print("nome: ")
                val nome = scanner.next()
                print("Origem: ")
                val origem = scanner.next()
                print("Dieta: ")
                val dieta = scanner.next()
                print("Tipo de Gaiola (SAVANA, AQUARIO, FLORESTA, OUTRO): ")
                val tipoGaiola = scanner.next().uppercase()
                print("Localização na Sela: ")
                val localizacao = scanner.next()

                val novoAnimal = Animal(nome, origem, dieta, TipoGaiola.valueOf(tipoGaiola), localizacao)
                zoo.adicionarAnimal(novoAnimal)
                println("Novo animal cadastrado com sucesso!")
            }
            2 -> {
                zoo.listarAnimais()
            }
            0 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (opcao != 0)
}