package Item37.kotlin

import java.util.*
import java.util.stream.Collectors.groupingBy
import java.util.stream.Collectors.toMap
import java.util.stream.Stream

enum class Phase {
    SOLID, LIQUID, GAS, PLASMA;

    enum class Transition private constructor(private val from: Phase, private val to: Phase) {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);


        companion object {

            // Initialize the phase transition map
            private val m : Map<Phase, Map<Phase, Transition>> = ((Stream.of(*values())
                    .collect<Phase, Map<Phase, Transition>>(groupingBy{t -> t.from; (EnumMap<Phase, Map<Phase, Transition>>(Phase::class.java))
                        toMap(t -> t.to; t -> t; (x, y) -> y; (EnumMap<Phase, Map<Phase, Transition>>(Phase::class.java))  })) as Map<Phase, Map<Phase, Transition>>?)!!

            fun from(from: Phase, to: Phase): Transition {
                return m[from]!!.getValue(to)
            }
        }

    }
}