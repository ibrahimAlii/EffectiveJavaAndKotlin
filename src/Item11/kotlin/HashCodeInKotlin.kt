package Item11.kotlin

/*
    The main premise is to calculate the hashCode based off your classes significant fields with the more unique the value,
     the better it is for storing in hash tables. Consider a data class which has a unique identifier, `id`:
 */
data class HashCodeInKotlin(val id: Int, val name: String, val age: Int) {

    override fun hashCode(): Int {
        return (id * 31 + (name.hashCode() ?: 0)) * 31 + age

    }


    //Although there’s nothing wrong with this per se, it will return results as expected,
    // if you already have a unique value, such as id, simply using that for the hashcode would be much more performant
    // as it would be with equals too.

    /*

    override fun hashCode(): Int {
        return id
    }

    */
}