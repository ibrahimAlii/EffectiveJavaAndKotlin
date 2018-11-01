package Item03.java;


// Singleton with public final field
public class SingleToneWithPublicFinalField {
    public static final SingleToneWithPublicFinalField INSTANCE = new SingleToneWithPublicFinalField();

    private SingleToneWithPublicFinalField() { /*... */}

    public void leaveTheBuilding() { /*...*/}
}

