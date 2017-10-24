# Kotlin Study Notes

## Observations 
- Challenges
  - in/out syntax in generic definition was confusing to apply in real use (sample code provided)
    - This chapter may have explained past challenges in declaring generics in Java
    - The chapter implies that it is better than Java, but I found it hard to implement a real example that made use of in/out
  - generic function within a class - difficult to do meaningful simple operations in that function
- Exciting features
  - Data classes - awesome
  - Great syntax for declaring a hierachy of classes and passing instantion parameters
  - Easy value assignment in enum declaration
  - delegation: lazy, observable, map - did not yet write any sample code
- Perhaps over-optimized features that are difficult to read
  - Else clause syntax for a sealed class
  - delcaring a single member interface implementation in a lambda (anonymous inner class)
  - syntax of parameters passed to the observable method
- Unclear examples
  - Locally delegated property
    - cool idea, but sample code is not illustrative enought
  

## [Data Class](dataClass.kt)
## Sealed Class 
- It seems like a very specific feature just to avoid an else clause.
- So, the value must be in having an enum that can contain data... perhaps as an initialize class that can be re-used.
- I am imagining building blocks of a specific type (add String widget, add Date widget, add number widget)
## Generics

Java | Kotlin | Note
---|---|---
`class Foo<T>(T t)` | `class Foo<T>(t: T)` | Generic Class Definition
`Foo<Integer> foo = new Foo<Integer>(1)` | `val box: Foo<Int> = Foo<Int>(1)` | Generic class instatiation - long form
`Foo<Integer> foo = new Foo<>(1)` | `val foo: Foo(1)` | Generic class instatiation - short form, generic parameters can be inferred in Kotlin

## Variance
- Declaration-site variance - variance is declared on class def
- Use-site variance - variance is declared in usage (method def)
  - `void addAll(Collection<? extends E> items)`
  - `add(List<? super String>)` 

Java | Kotlin | Note
---|---|---
`Foo<E>`| Foo<E>|Invariant, type must match generic declaration 
`Foo<? extends E>` (Producer Extends)|`Foo<out E>`|Covariant Upper Bound 
`Foo<? super String>)` (Consumer Subtypes) |`Foo<in E>`|Contravariant Lower Bound

#### Java Note:
  - T extends ClassName supported in class def
  - ? extends ClassName supported in class def
  - ? super ClassName supported in class def
  - T super ClassName does not seem to be supported

#### Kotlin sample generic code
- [generics.kt](generics.kt)
  - [Java Equivalent](test1/src/main/java/demo/MyDemo.java)

## Star Projection
    class Foo<out TUpper>{
      fun get(): <out TUpper> {} //is this the correct meaning of TUpper? 
      fun get(): <*> {} 
      fun get(): <out Any?> {} 
    }

    class Foo<T>{
      fun set(<in Nothing>): {} 
      fun set(<*>): {} 
    }

- https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/
- https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing.html  
  - Kotlin Nothing has no equivalent in java
- https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html
  - Kotlin Unit is similar to void

## Generic Functions within a class
- [genericFun.kt](genericFun.kt)


## Generic Constraints within a class function

## Nested Classes/Inner Classes
- Inner designation is nice

## Anonymous Inner Class
The following may be a nice shortcut, but it does not read clearly
- If the object is an instance of a functional Java interface (i.e. a Java interface with a single abstract method), you can create it using a lambda expression prefixed with the type of the interface:

## Enum Classes
- Member value setting is very nice
- [enum.kt](enum.kt)

## Objects
- Object expression
- object declaration (singleton)
- companion object

## Delegation
- Delegation syntax
- Lazy
- Observable
  - The 3 parameter syntax is not very clear
- Vetoable
- Delegation to a map
  - Very promising - I am curious to use this 
- provide delegate object
