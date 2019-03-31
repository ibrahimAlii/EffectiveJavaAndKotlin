package Item39.java;

import java.lang.annotation.Annotation;

public class ExceptionTestContainer implements Annotation {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
