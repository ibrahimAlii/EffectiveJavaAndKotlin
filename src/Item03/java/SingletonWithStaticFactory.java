package Item03.java;


// Singleton with static factory
public class SingletonWithStaticFactory {
    private static final SingletonWithStaticFactory INSTANCE = new SingletonWithStaticFactory();

    private SingletonWithStaticFactory() { /*...*/}

    public static SingletonWithStaticFactory getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() { /*...*/}
}

