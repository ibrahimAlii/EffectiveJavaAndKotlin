package Item01.samples.kotlin.sample2

abstract class Provider<T> {
    var original: T? = null
    var mocked: T? = null
    abstract fun create(): T
    fun get(): T = mocked ?: original ?: create()
            .apply { original = this }

    fun lazyGet(): Lazy<T> = lazy { get() }
}
