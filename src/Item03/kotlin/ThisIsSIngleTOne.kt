package Item03.kotlin

object ThisIsSingleton {
    val prop = 10
    fun method() = 20
}
// Usage
print(ThisIsSingleton.prop) // 10
print(ThisIsSingleton.method()) // 20
