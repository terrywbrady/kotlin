/**
 * We declare a package-level function main which returns Unit and takes
 * an Array of strings as a parameter. Note that semicolons are optional.
 */

open class MyString(val s: String) {
    override public fun toString() = this::class.toString() + " " + s
}
open class MyLongString(s: String): MyString(s) {}
open class MyExtraLongString(s: String): MyLongString(s) {}
open class MyExtraExtraLongString(s: String): MyExtraLongString(s) {}
class MyLongestString(s: String): MyExtraExtraLongString(s) {}

class MyList<T> {
  var list = ArrayList<T>()
  fun add(item: T) {
      list.add(item)
  }
  fun copyAll(input: MyList<T>): Boolean {
    return list.addAll(input.list);
  }
}

fun main(args: Array<String>) {
  var ms    = MyString("foo")
  var mls   = MyLongString("foo")
  var mels  = MyExtraLongString("foo")
  var meels = MyExtraExtraLongString("foo")
  var mlst  = MyLongestString("foo")
  println(ms)
  println(mls)
  println(mels)
  println(meels)
  println(mlst)
  
  var myList: MyList<MyLongString> = MyList<MyLongString>()
  var myList2: MyList<MyLongString> = MyList<MyLongString>()
  var myExtraLongList = MyList<MyExtraLongString>()
  myList2.add(mels)
  myList2.add(meels)
  myList.copyAll(myList2)
  myExtraLongList.add(mels)
  myExtraLongList.add(meels)
  myList.copyAll(myExtraLongList);  
}

