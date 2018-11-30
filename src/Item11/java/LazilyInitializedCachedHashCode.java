package Item11.java;

public class LazilyInitializedCachedHashCode {
    private int hashCode; // Automatically initialized to 0

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(someObject);
            result = 31 * result + Short.hashCode(anotherObj);
            result = 31 * result + Short.hashCode(anotherObject);
            hashCode = result;
        }

        return result;
    }
}
