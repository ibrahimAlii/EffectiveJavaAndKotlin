package Item03;


// https://medium.com/@biratkirat/learning-effective-java-item-3-6552c87d8e54
// http://www.informit.com/articles/article.aspx?p=1216151&seqNum=3

/**
 * The main benefit of using this pattern is that we can reuse objects.
 * <p>
 * <p>
 * We can handle the state change easily which is handled by this instance object.
 * <p>
 * There are 2 ways (prior to Java 1.5) to implement singletons by making constructor private and exporting
 * a public static member to provide access to the sole instance.
 * The FIRST approach:
 * We make the member a public final field.
 * And, the private constructor is only called once, to initialize the public static final field.
 * This makes for a single instance of the object, except for we can invoke using reflection.
 * <p>
 * There are 2 ways (prior to Java 1.5) to implement singletons by making constructor private and exporting
 * a public static member to provide access to the sole instance.
 * The FIRST approach:
 * We make the member a public final field.
 * And, the private constructor is only called once, to initialize the public static final field.
 * This makes for a single instance of the object, except for we can invoke using reflection.
 * <p>
 * The SECOND approach. Also called LAZY INITIALIZATION
 * We make the member variable private and constructor as private.
 * A public static factory method is used to get reference to the object.
 * Call to this method will return the same object reference, no other instance will ever be created (except for invoking with reflection)
 */

/**
 * There are 2 ways (prior to Java 1.5) to implement singletons by making constructor private and exporting
 * a public static member to provide access to the sole instance.
 * The FIRST approach:
 * We make the member a public final field.
 * And, the private constructor is only called once, to initialize the public static final field.
 * This makes for a single instance of the object, except for we can invoke using reflection.
 */

/**
 * The SECOND approach. Also called LAZY INITIALIZATION
 * We make the member variable private and constructor as private.
 * A public static factory method is used to get reference to the object.
 * Call to this method will return the same object reference, no other instance will ever be created (except for invoking with reflection)
 */

/**
 * The PREFERRED approach on creating singleton
 * Using Enum
 * As of Java 1.5 simply make an enum type with one element;
 * // Enum singleton — the preferred approach
 * public enum VolleySingleton {
 * INSTANCE;
 * public void makeNetworkCall(){ ... }
 * }
 * This is functionally equivalent to the public field approach
 * It is is concise.
 * Provides the serialization machinery for free.
 * Guarantees against multiple instantiation even with sophisticated serialization or reflection attacks.
 */
public class EnforceSingletonPropertyWithPrivateConstructorOrEnumType {
}
