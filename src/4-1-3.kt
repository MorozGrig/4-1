import kotlin.random.Random

fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬЭЮЯ"
    println("Введите исходное сообщение:")
    val message = readLine()!!.uppercase()

    println("Введите ключ:")
    val key = readLine()!!.uppercase()

    val vigenereTable = generateRandomTable(alphabet)

    val repeatedKey = repeatKey(key, message.length)
    val encryptedMessage = encryptMessage(message, repeatedKey, vigenereTable)

    printOutput(message, repeatedKey, encryptedMessage, vigenereTable)
}

fun repeatKey(key: String, length: Int): String {
    val repeatedKey = StringBuilder()
    for (i in 0 until length) {
        repeatedKey.append(key[i % key.length])
    }
    return repeatedKey.toString()
}

fun generateRandomTable(alphabet: String): List<String> {
    val table = mutableListOf<String>()

    val randomShift = Random.nextInt(1, alphabet.length)

    for (i in alphabet.indices) {
        val shift = (i + randomShift) % alphabet.length // Сдвиг по индексу
        val row = alphabet.substring(shift) + alphabet.substring(0, shift)
        table.add(row)
    }
    return table
}

fun encryptMessage(message: String, key: String, vigenereTable: List<String>): String {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬЭЮЯ"
    val encryptedMessage = StringBuilder()

    for (i in message.indices) {
        val messageChar = message[i]
        val keyChar = key[i]

        if (messageChar in alphabet) {
            val messageIndex = alphabet.indexOf(messageChar)
            val keyIndex = alphabet.indexOf(keyChar)
            val encryptedChar = vigenereTable[keyIndex][messageIndex]
            encryptedMessage.append(encryptedChar)
        } else {
            encryptedMessage.append(messageChar)
        }
    }
    return encryptedMessage.toString()
}

fun printOutput(message: String, key: String, encrypted: String, table: List<String>) {
    println("\nИсходное сообщение: $message")
    println("Ключ: $key")
    println("Зашифрованное сообщение: $encrypted")

    println("\nШифровальная таблица:")
    for (row in table) {
        println(row)
    }
}