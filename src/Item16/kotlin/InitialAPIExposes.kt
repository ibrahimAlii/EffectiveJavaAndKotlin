package Item16.kotlin

//perhaps initially your API exposes a String, but internally you now want to represent this as an Int, you could do the following:

class Example {
    private var newField: Int = 0

    var oldField: String
        get() {
            return newField.toString()
        }
        set(value) {
            newField = value.toInt()
        }
    //...
}
/*
 One of the reasons for Java it is considered less important to ensure internal classes have accessors
 for fields is because of the code explosion you have with getters and setters. However, since Kotlin hides this from you,
 there is no such concern.
 */