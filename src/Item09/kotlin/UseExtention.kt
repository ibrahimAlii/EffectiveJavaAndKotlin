package Item09.kotlin

//try-with-resources, doesn’t exist in Kotlin.

//Instead, Kotlin introduces the extension function use which will call close() on a Closeable
// when the block provided completes or throws an exception.


/*

   inputStream.use {
      // do something with the stream
      it.read()
    }

*/