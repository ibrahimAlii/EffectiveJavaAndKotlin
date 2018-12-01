package Item12.kotlin

//The toString produced in a data class lists each property in order of definition. The code below will produce the
// string “User(name=Bob, age=30)”:

data class User(val name: String, val age: Int)

//println(User("Bob", 30))
//Joshua says, “when practical, the toString method should return all of the interesting information contained in the object.
// ” but that’s to say there are circumstances under which the string remains concise but informed.
// You want the output to contain enough valuable information but not too much. So just because a data class defines a toString
// doesn’t mean you shouldn’t override it.