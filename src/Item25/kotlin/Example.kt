package Item25.kotlin

/*
  Kotlin compiler doesn’t automatically search for source files it will search the classpath if you ask it and so
   can still lead to undesirable behaviour. Consider the following three files:

// Main.kt
fun main(args: Array<String>) {
    System.out.println(Utensil.NAME + Dessert.NAME)
}
// Utensil.kt
object Utensil {
    const val NAME = "pan"
}
object Dessert {
    const val NAME = "cake"
}
// Dessert.kt
object Utensil {
    const val NAME = "pot"
}
object Dessert {
    const val NAME = "pie"
}



When you execute kotlinc Utensil.kt, the compiler will generate two top-level class files,
 Utensil.class and Dessert.class. When you then execute kotlinc Dessert.kt,
 the compiler will also generate two top-level class files overriding the ones from the previous command.


 Compiling Main.kt with kotlinc -include-runtime -d out.jar Main.kt and executing the resulting jar will print
  the output of whichever of Utensil.kt or Dessert.kt you compiled last.


Although the example may seem contrived, it still highlights the complexities of compilation and a good reason
 why you should “never put multiple top-level classes or interfaces in a single source file”.

Kotlin removes Java’s restriction around multiple public classes in a file,
but I still believe it to be good practice to keep classes and interfaces separate.

For one it makes finding definitions by browsing the source folders much easier without having to check-out the code base
 into an IDE and also better enforces the idea of single responsibility.

        */