package testing.kotling

fun main() {
    println("Ingrese el primer número")
    val numA = readLine()?.toIntOrNull()
    if (numA == null) {
        println("Número no válido")
        return
    }
    println("Ingrese el segundo número")
    val numB = readLine()?.toIntOrNull()
    if (numB == null) {
        println("Número no válido")
        return
    }
    if (checkFriends(numA!!, numB!!)) {
        println("Los numeros " + numA + " y " + numB + " son amigos")
    } else {
        println("Los numeros " + numA + " y " + numB + " no son amigos")
    }
}

fun checkFriends(numA: Int, numB: Int): Boolean {
    return ((sumDivisor(numA) == numB) && (sumDivisor(numB) == numA))
}

fun sumDivisor(num: Int): Int {
    var divisorSum = 0
    for (i in 1..num) {
        if (i != num && num % i == 0) {
            divisorSum += i
        }
    }
    return divisorSum
}