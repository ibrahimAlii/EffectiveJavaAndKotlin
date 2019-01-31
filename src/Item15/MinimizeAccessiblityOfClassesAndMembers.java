package Item15;


public class MinimizeAccessiblityOfClassesAndMembers {


    // In JAVA
    /**
     *  <private> The member is accessible only from the top-level class where it is declared </private>
     *
     *  <package-private> The member is accessible from any class in the package where it is declared.
     *  Technically known as default access, this is the access level you get if no access modifier is specified
     *  (except interface members which are public by default. </package-private>
     *
     *  <protected> The member is accessible from subclasses of the class where it's declared, and from any class in
     *  the package where it's declared </protected>
     *
     *  <public> The member is accessible from anywhere. </public>
     */


    // In Kotlin
    /**
     * <private> top-level definitions visible in their file, class members only visible in their class. </private> 
     *
     * <protected > not applicable to top-level definitions, class members visible in their class and subclasses. </protected >
     *
     * <internal >top-level definitions visible in the same module, class members visible in the same module where their class is visible. </internal >
     *
     * <public >  top-level definitions visible everywhere, class members visible everywhere their class is visible. </public >
     */

    // You shouldReduce accessibility of program elements as mush as possible (within reason).
}

