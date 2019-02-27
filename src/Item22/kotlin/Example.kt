package Item22.kotlin

/*
  In Java there are two approaches, use an enum type (item 34) or a non-instantiable utility class (item 4).
   Using Kotlin’s Object declarations is one way to create such a class:

 */

object PhysicsConstants {
    const val ELECTRON_MASS = 9.109_383_56e-31
}

/*
  The const modifier marks the property as a compile-time constant which improves performance by giving direct access
  without a getter along with the possibility of being inlined.
  An alternative to creating an object, as above, is to use top-level declarations where possible.
  For better Java compatibility you should use the @file:JvmName annotation, so the constants don’t appear in a file postfixed with “Kt”.
 */


@file:JvmName("PhysicsConstants")

const val ELECTRON_MASS = 9.109_383_56e-31

/*
  However, as Dmitry Jemerov from JetBrains says in Best practices for top-level declarations: https://discuss.kotlinlang.org/t/best-practices-for-top-level-declarations/2198/3

  The recommended practice is to never use object for creating namespaces,
  and to always use top-level declarations when possible. We haven’t found name conflicts to be an issue, and if you do get a conflict,
  you can resolve it using an import with alias.
  While I agree about the use of top-level declarations for extension functions
   I’m still not entirely convinced about their use for constants — perhaps
    I like namespaces but that being said realistically in a single code base how often do you have two constants in different classes with the same name. What are your thoughts?

  For a more in-depth dive into constants on Kotlin I highly recommend reading Where Should I Keep My Constants in Kotlin?
   https://blog.egorand.me/where-do-i-put-my-constants-in-kotlin/
 */
