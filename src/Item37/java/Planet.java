package Item37.java;

public enum Planet {
    ;

    public enum LifeCycle{ ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    public final LifeCycle lifeCycle;

    Planet(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
