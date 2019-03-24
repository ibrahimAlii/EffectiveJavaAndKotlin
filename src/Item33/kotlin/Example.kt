package Item33.kotlin

/*
 In kotlin reified object is here
 */

public class Favorites{

    inline fun <reified T> putFavorite(type: Class<T>, instance: T){}
    inline fun <reified T> getFavorite(type: Class<T>) : T{}
}