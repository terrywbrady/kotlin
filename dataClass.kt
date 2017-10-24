data class Foo(var cat: String = "----", var dog: String = "....", var kitty: String = "===", var bird: String = "___") {
    
}

fun main(args: Array<String>) {
    var foo = Foo("aa", "bb");
    println("Hello, $foo!")
    println("Hello, ${Foo("ddd")}")
    println("Hello, ${Foo("eeee","ddd")}")
    println("Hello, ${Foo("eeee","ddd").copy(bird = "tweet")}")
    println(foo.component3())
    var (a, b, c, d) = foo;
    println("$c-->$d")
    println("${Triple(1,2,"xxx")}; ${Pair("aaa",22)}")
}
