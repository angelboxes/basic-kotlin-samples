package testing.kotling

import java.security.InvalidParameterException
import kotlin.math.pow


open class Figure {
    open fun area(): Double {
        return 0.00
    }

    open fun perimeter(): Double {
        return 0.00
    }
}

class Square(val side: Double) : Figure() {

    override fun area(): Double {
        return side.pow(2)
    }

    override fun perimeter(): Double {
        return side * 4
    }
}

class Rectangle(val width: Double, val heigth: Double) : Figure() {

    override fun area(): Double {
        return width * heigth
    }

    override fun perimeter(): Double {
        return width * 2 + heigth * 2
    }
}

class Circle(val radius: Double) : Figure() {

    override fun area(): Double {
        return Math.PI * radius.pow(2)
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

fun main() {
    println("Cree una figura de las siguientes opciones:\n1.Cuadrado\n2.Rectángulo\n3.Círculo")
    val option = readLine()?.toIntOrNull()
    var figure: Figure
    when (option) {
        1 -> figure = createSquare()
        2 -> figure = createRectangle()
        3 -> figure = createCircle()
        else -> {
            println("Opción no válida")
            return
        }
    }
    println("Área: " + figure.area())
    println("Perímetro: " + figure.perimeter())
}

fun readParameter(): Double {
    val side = readLine()?.toDoubleOrNull()
    if (side == null || side < 0) {
        println("Parámetro no válido")
        throw InvalidParameterException()
    } else {
        return side
    }
}

fun createSquare(): Figure {
    println("Ingrese tamaño")
    val side = readParameter()
    return Square(side)
}

fun createRectangle(): Figure {
    println("Ingrese ancho")
    val width = readParameter()
    println("Ingrese alto")
    val heigth = readParameter()
    return Rectangle(width, heigth)
}

fun createCircle(): Figure {
    println("Ingrese radio")
    val radius = readParameter()
    return Circle(radius)
}

