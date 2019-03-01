package Item24.kotlin

/*
   On Android, non-static member classes and anonymous classes have been the cause of many memory leaks as,
    for example, the code below shows an AsyncTask that implicitly holds a reference to the Activity until the long-running task completes:
 */

/*
public class LeakyActivity extends Activity {

    …

    private class LongRunningTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
        // Long running task occurs here

        return "Task complete";
    }
    }
}

*/

/*
  Kotlin’s approach to classes means that member classes are static by default with the inner modifier being explicitly
   added to a class for it to become a non-static member class and thus have an implicit reference to the outer class,
    i.e. the opposite to Java’s static modifier.
 */

class OuterClass {
    // static member class
    class NestedClass {}

    // non-static member class
    inner class InnerClass {}
}


/*
   Anonymous classes and lambdas in Kotlin are inner classes, so caution still applies when using those.
 */