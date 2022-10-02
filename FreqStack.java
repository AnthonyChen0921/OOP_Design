
import java.util.*;

public class FreqStack {

    // map for frequency
    private Map<Integer, Integer> freqMap;
    // map for stack
    private Map<Integer, Stack<Integer>> stackMap;
    // max frequency
    private int maxFreq;

    /**
     * @breif: constructor
     *
     */
    public FreqStack() {
        // initialize
        freqMap = new HashMap<Integer, Integer>();
        stackMap = new HashMap<Integer, Stack<Integer>>();
        maxFreq = 0;
    }
    
    /**
     * @breif: push element
     * @param x element to push
     */
    public void push(int x) {
        // update frequency
        int freq = freqMap.getOrDefault(x, 0) + 1;
        // update max frequency
        freqMap.put(x, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        // update stack
        if (!stackMap.containsKey(freq)) {
            // create new stack
            stackMap.put(freq, new Stack<Integer>());
        }
        // push to stack
        stackMap.get(freq).push(x);
    }
    
    /**
     * @breif: pop element
     * @return element popped
     */
    public int pop() {
        // get the max frequency stack
        int x = stackMap.get(maxFreq).pop();
        // update frequency
        freqMap.put(x, freqMap.get(x) - 1);
        if (stackMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return x;
    }
}