package testing.kotling

fun main(){
    for (i in 1..10){
        var result = fibonacci(i)
        result?.let { println(result) }
    }
}

fun fibonacci(num: Int): Int? {
    if (num==0){
        return 0
    }else if (num==1){
        return 1
    }else if (num>1){
        return (fibonacci(num-1)!!+ fibonacci(num-2)!!)
    }
    return null
}