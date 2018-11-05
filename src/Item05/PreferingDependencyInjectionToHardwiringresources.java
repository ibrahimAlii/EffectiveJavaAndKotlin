package Item05;


/**
 * Static utility classes and singletons are inappropriate for classes whose behavior is parameterized by an underlying
 * resource.
 */

/**
 * A simple Pattern that satisfies the requirement is to pass the resource into the constructor when creating a new instance.
 * This one form of dependency injection
 */

// Dont use a singleton or static utility class to implement a class that depends on one or more underlying resources whose
    // behavior affects that of the class, and don't have the class create these resource directly.
    // Instead, pass the resources, or factories to create them into the constructor(or static factory or builder).
public class PreferingDependencyInjectionToHardwiringresources {
}
