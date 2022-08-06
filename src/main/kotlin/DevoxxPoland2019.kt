class Printer {
    companion object {
        fun print(arg: Any) = println(arg)
    }
}

fun printMe(arg: Any) = println(arg)

fun main() {
    val numbers = listOf(1, 2, 3)

    // external iterators
    for (num in numbers) {
        println(num)
    }

    // internal iterators, all of these do the same thing
    numbers.forEach({ e -> println(e) }) // can also move arg out of ()
    numbers.forEach { println(it) } // implicit 'it' element
    numbers.forEach(::printMe)
    numbers.forEach(Printer::print) // use function reference in a pass-through lambda (lambda that only takes an input and pass it to something else)

    // storing lambdas as variables, these do the same thing
    val printItA: (Int) -> Unit = { number -> println(number) }
    val printItB = { number: Int -> println(number) } // prefer this over printItA

    printItA(5)
    printItB(5)
}