package Item35.java;

public enum  Ensemble {

    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7),
    OCTET(8), DOUBLE_QUARTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);


    private final int size;
    Ensemble(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    // Don't do this
//    public int getSize(){
//        return ordinal() + 1;
//    }
}
