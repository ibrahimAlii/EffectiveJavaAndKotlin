package Item08;

/**
 * @Finalizer are unpredictable, often dangerous, and generally unnecessary.
 *
 * @Cleaners are less dangerous than finalizer, but still unpredictable, slow, and generally unnecessary
 *
 */

/*
  - Never do anything time-critical in a finalizer or cleaner.

  - Never depend on a finalizer or cleaner to update presistent state.

 */

/*
  Finalizer have a serious problem: they open your class up to finalizer attack[e.g: exception thrown]
 */
public class AvoidFinalizerAndCleaners {

}
