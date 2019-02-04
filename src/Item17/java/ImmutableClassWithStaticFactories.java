package Item17.java;

public class ImmutableClassWithStaticFactories {

    private final double someThing1;
    private final double someThing2;

    private ImmutableClassWithStaticFactories(double someThing1, double someThing2){
        this.someThing1 = someThing1;
        this.someThing2 = someThing2;
    }

    public static final ImmutableClassWithStaticFactories valueOf(double someThing1, double someThing2){
        return new ImmutableClassWithStaticFactories(someThing1, someThing2);
    }
}
