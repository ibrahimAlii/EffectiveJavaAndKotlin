package Item38.java;

public enum ExtendedOperation implements Operation {

    EXP("^"){
        @Override
        public double apply(double x, double y) { return Math.pow(x, y); }
    },
    REMINDER("%"){
        @Override
        public double apply(double x, double y) { return x % y; }
    };

    private final String symbol;

    ExtendedOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
