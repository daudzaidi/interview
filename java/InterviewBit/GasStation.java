package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        if(gas == null || cost == null || gas.size() == 0 || cost.size() == 0 ||
                gas.size() != cost.size())
        return -1;
        int n = gas.size();

        int sumRemaining= 0;
        int total = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            int remaining = gas.get(i) - cost.get(i);
            if(sumRemaining >= 0)
                sumRemaining += remaining;
            else{
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if(total >= 0)
            return start;
        else return -1;
    }

    public int canCompleteCircuitII(final List<Integer> gas, final List<Integer> cost) {
        for (int start = 0; start < gas.size(); start++) {
            int i = start;
            int g = gas.get(start);
            while (true) {
                g -= cost.get(i);
                if (g < 0) break;
                i = (i + 1) % cost.size();
                if (i == start) return i;
                g += gas.get(i);
            }
        }
        return -1;
    }

    public static void main(String... args){
        GasStation g = new GasStation();
        ArrayList<Integer> gas = new ArrayList<Integer>();
        gas.add(1);
        gas.add(2);
        ArrayList<Integer> cost = new ArrayList<Integer>();
        cost.add(2);
        cost.add(1);
        System.out.println(g.canCompleteCircuit(gas,cost));
    }


}
