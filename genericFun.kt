class Foo {
    //T on its own may be null
    //T: Any cannot be null
    //T: Any? may be null
    fun <T: Any> triple(t: T): T{
        return t
        //Any does not support plus().  There is no other common ancestor for Int and String
        //return t + t + t
        //return t.plus(t).plus(t)
    }
}

fun main(args: Array<String>) {
    println(2+2+2)
    println("xx"+"xx"+"xx")

    println(Foo().triple<Int>(2))
    println(Foo().triple<String>("xx"))
}
