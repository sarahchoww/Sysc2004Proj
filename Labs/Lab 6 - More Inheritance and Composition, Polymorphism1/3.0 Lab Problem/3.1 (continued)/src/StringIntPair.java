/**
 * This document depicts the class StringIntPair. It is used to keep track of the non-emoji reactions in
 * PollPost objects.
 * @author Sarah Chow, L3
 */
public class StringIntPair {
    public final String s;
    public int i;

    /**
     * This constructor sets the new reaction and the frequency.
     * @param s represents the reaction, String
     * @param i represents the frequency, int
     */
    public StringIntPair(String s, int i) {
        this.s = s;
        this.i = i;
    }

    /**
     * This is a getter for the frequency of the reaction.
     * @return an integer representing the frequency of the reaction, int
     */
    public int getI() {
        return i;
    }

    /**
     * This is a getter for the reaction.
     * @return a String representing the reaction, String
     */
    public String getS() {
        return s;
    }

    /**
     * This is a setter for the frequency of the reaction.
     * @param i represents the new frequency of the reaction, int
     */
    public void setI(int i){
        this.i = i;
    }
}
