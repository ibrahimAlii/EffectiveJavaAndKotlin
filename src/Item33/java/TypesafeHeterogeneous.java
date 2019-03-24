package Item33.java;

public class TypesafeHeterogeneous {

    // Typesafe heterogenous container pattern - API
    public class Favorites{
        public <T> void putFavorite(Class<T> type, T instance);
        public <T> T getFavorite(Class<T> type);
    }



}
