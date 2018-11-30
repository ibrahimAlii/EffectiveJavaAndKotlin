package Item11.java;

import java.util.Objects;

public class MediocrePerformance {

    // One-line hashCode method - mediocre performance

    @Override
    public int hashCode() {
        return Objects.hash(object1, object2, objectN);
    }
}
