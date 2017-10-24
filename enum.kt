enum class Color(val rgb: Int, val foo: String = "xxx") {
        RED(0xFF0000, "dd"),
        GREEN(0x00FF00, "cc"),
        BLUE(0x0000FF)
}
fun main(args: Array<String>) {
    //it does not appear that you can treat the values as data class values
    for(i in  Color.values()) {
        println("$i ${i.rgb} ${i.foo}")
    }
}