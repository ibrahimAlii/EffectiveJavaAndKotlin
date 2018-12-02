package Item13.java;

public class CloneForExtenableClassNotSupportingClone {


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
