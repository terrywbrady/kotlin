class Foo {
    fun <T> triple(t: T): T{
        return t
        //eturn t + t + t
        //return t.plus(t).plus(t)
    }
}

fun main(args: Array<String>) {
    println(2+2+2)
    println("xx"+"xx"+"xx")

    println(Foo().triple<Int>(2))
    println(Foo().triple<String>("xx"))
}