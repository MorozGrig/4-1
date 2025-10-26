import kotlin.random.Random

fun main() {
    val options = mapOf(1 to "Камень", 2 to "Ножницы", 3 to "Бумага")
    while (true) {
        println("Выберите: \n1 - Камень\n2 - Ножницы\n3 - Бумага")
        val playerChoice = readLine()?.toIntOrNull()
        if (playerChoice !in 1..3) {
            println("Некорректный ввод, попробуйте снова.")
            continue
        }
        val computerChoice = Random.nextInt(1, 4)

        println("Вы выбрали: ${options[playerChoice]}")
        println("Компьютер выбрал: ${options[computerChoice]}")

        if (playerChoice == computerChoice) {
            println("Ничья! Играем еще раз.\n")
            continue
        }

        val playerWins = (playerChoice == 1 && computerChoice == 2) ||
                (playerChoice == 2 && computerChoice == 3) ||
                (playerChoice == 3 && computerChoice == 1)

        if (playerWins) {
            println("Вы выиграли!")
        } else {
            println("Вы проиграли!")
        }
        break
    }
}