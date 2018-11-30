package Item09.kotlin

//try-with-resources, doesn’t exist in Kotlin.

//Instead, Kotlin introduces the extension function use which will call close() on a Closeable
// when the block provided completes or throws an exception.

/*

inputStream.use {
    outputStream.use {
        // do something with the streams
        outputStream.write(inputStream.read())
    }
}

*/


//If in your app you are constantly dealing with multiple resources then this can still look pretty messy,
// but with Kotlin’s extension methods we can help improve this situation:

/*
private inline fun <T : Closeable?> Array<T>.use(block: ()->Unit) {
    var exception: Throwable? = null
    try {
        return block()
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        when {
            exception == null -> forEach { it?.close() }
            else -> forEach {
                try {
                    it?.close()
                } catch (closeException: Throwable) {
                    exception.addSuppressed(closeException)
                }
            }
        }
    }
}

*/

//Allowing you to turn the original example into:

/*
arrayOf(inputStream, outputStream).use {
    // do something with the streams
    outputStream.write(inputStream.read())
}
*/

