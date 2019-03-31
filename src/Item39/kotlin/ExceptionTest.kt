package Item39.kotlin

import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

// Repeatable annotation type
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Repeatable
annotation class ExceptionTest(val value: KClass<out Exception>)