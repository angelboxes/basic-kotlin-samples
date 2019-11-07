package testing.kotling

fun main() {
    println("Imprima la cantidad de coordenadas a ingresar")
    var n = readLine()!!.toInt()
    var rectangles = 0
    var xAxis = sortedMapOf<Int, HashSet<Int>>()
    for (i in 1..n) {
        println("Ingrese coordenadas x,y")
        val coordinateList = readLine()?.split(",".toRegex(), 2)
        if (coordinateList!!.size != 2) {
            println("Coordenadas inválidas")
            return
        }
        val (x, y) = coordinateList!!.toTypedArray().map { it.toInt() }
        val xPoints = xAxis.getOrDefault(x, HashSet())
        xPoints.add(y)
        xAxis[x] = xPoints
    }
    for (axis1 in xAxis.keys) {
        for (axis2 in xAxis.keys) {
            if (axis1 < axis2) {
                rectangles += sum(xAxis[axis1]!!.intersect(xAxis[axis2]!!).size - 1)
            }
        }
    }
    println("Se pueden crear $rectangles rectángulos con los puntos proporcionados")
}

fun sum(x: Int): Int {
    return if (x == 0) 0 else x + sum(x - 1)
}