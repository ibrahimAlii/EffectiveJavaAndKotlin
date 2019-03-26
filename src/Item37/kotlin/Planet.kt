package Item37.kotlin

enum class Planet private constructor(internal val lifeCycle: LifeCycle) {;


    internal enum class LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    override fun toString(): String {
        return name // name already a variable in kotlin
    }
}