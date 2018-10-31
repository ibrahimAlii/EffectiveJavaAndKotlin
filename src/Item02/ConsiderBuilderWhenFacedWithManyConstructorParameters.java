package Item02;

/**
 * @Telescoping constructor pattern works, but it's hard to write client code when there are many parameters,
 * and harder still to read it.
 *
 *
 * @JavaBean patterns has serious disadvantage of it's own.
 * Because construction is split across multiple calls, **A JavaBean may be in and inconsistent state partway through
 * its construction.
 *
 * @JavaBean pattern precludes the possibility of making class immutable
 *
 *
 *
 * @Builder pattern easy to write and more importantly, easy to read.
 * It's simulates named optional parameters as found in Python and Scala.
 *
 * @Builder patten is well suited to class hierarchies
 *
 *
 */

/**
 *  @Builder pattern is good choice when designing classes whose constructors or static factories would have more
 *  than a handful of parameters.
 */
public class ConsiderBuilderWhenFacedWithManyConstructorParameters {
}
