package InterviewBit;

/**
 * Created by shalvi on 27/07/16.
 */

import java.util.ArrayList;

/**
 * Definition for an interval.
 **/

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class MergeIntervals {
    public static void main(String... args){
        ArrayList<Interval> intervals = new ArrayList<>();
       intervals.add(new Interval(3,5));//[ (6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999), (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097) ];
        intervals.add(new Interval(8,10));
/*        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));*/
        //intervals.add(new Interval());
/*        intervals.add(new Interval(7790713, 9332533));
        intervals.add(new Interval(10755183, 11155540));
        intervals.add(new Interval(11880594, 16372598));
        intervals.add(new Interval(20253304, 21480099));
        intervals.add(new Interval(21594791, 32554370));
        intervals.add(new Interval(37491833, 42144750));
        intervals.add(new Interval(47246399, 48594350));
        intervals.add(new Interval(55564470, 65968466));
        intervals.add(new Interval(68003756, 74442674));
        intervals.add(new Interval(76298468, 78101486));
        intervals.add(new Interval(81417190, 83823945));
        intervals.add(new Interval(84742054, 88369776));*/

/*        intervals.add(new Interval(31935139, 38366404));
        intervals.add(new Interval(54099301, 76986474));
        intervals.add(new Interval(87248431, 94675146));*/

        //ArrayList<Interval> result = insert(intervals,new Interval(2558064, 96618465));
       // ArrayList<Interval> result = insert(intervals,new Interval(43262807, 68844111));
        ArrayList<Interval> result2 = insert2(intervals,new Interval(10, 3));
    }
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if (intervals == null && newInterval == null) {
            return null;
        }

        if (newInterval == null) {
            return intervals;
        }

        if(intervals == null){
            intervals = new ArrayList<>();
            intervals.add(newInterval);
        }
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }

        int len = intervals.size();

        if(newInterval.start > newInterval.end ){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        if(len == 1 && intervals.get(0).start == intervals.get(0).end){
            intervals.get(0).start = (newInterval.start >= intervals.get(0).start) ? intervals.get(0).start : newInterval.start;
            intervals.get(0).end = (newInterval.end <= intervals.get(0).end) ? intervals.get(0).end : newInterval.end;
            return intervals;
        }

        //Case 1: new Interval preceeding all elements in intervals
        if (newInterval.end < intervals.get(0).start) {
            Interval temp = new Interval(newInterval.start, newInterval.end);

/*            for (int i = len - 1; i >= 0; i--) {
                intervals.add(i + 1, intervals.get(i));
            }*/
            intervals.add(0, temp);
            return intervals;
        }

        //Case 2: new Interval succeeding all elements in intervals
        if (newInterval.start > intervals.get(len - 1).end) {
            Interval temp = new Interval(newInterval.start, newInterval.end);
            intervals.add(len, temp);
            return intervals;
        }

        //Case 3:
        if(newInterval.start <= intervals.get(0).start && newInterval.end >= intervals.get(intervals.size() -1).end){
            intervals.get(0).start = newInterval.start;
            intervals.get(0).end = newInterval.end;
            int leng = intervals.size() -1;
            for(int l = leng ; l>=1 ;l--){
                intervals.remove(l);
            }
            return intervals;
        }

        //Case 4: new Interval in between but non overlapping
        for (int i = 0; i < len - 1; i++) {
            if (newInterval.start > intervals.get(i).end && newInterval.end < intervals.get(i + 1).start) {
                Interval temp = new Interval(newInterval.start, newInterval.end);
                intervals.add(i + 1, temp);
                return intervals;
            }
        }

        //Case 5: new Interval in between and overlapping
        int insertStartIndex1 = 0;
        int insertStartIndex2 = 0;
        int insertEndIndex1 = 0;
        int insertEndIndex2 = 0;
        int i = 0;

        for (Interval element : intervals) {

            if (element.start >= newInterval.start) {
                insertStartIndex1 = i;
                break;
            }

            if (element.end >= newInterval.start) {
                insertStartIndex2 = i;
                break;
            }
            i++;
        }

        for (int j = i + 1; j < intervals.size(); j++) {
            if (intervals.get(j).start >= newInterval.end) {
                insertEndIndex1 = j;
                break;
            }

            if (intervals.get(j).end >= newInterval.end) {
                insertEndIndex2 = j;
                break;
            }
        }

        int start = (insertStartIndex1 == 0) ? insertStartIndex2 : insertStartIndex1;
        int startPos = (insertStartIndex1 == 0) ? 1 : 0;
        int end = (insertEndIndex1 == 0) ? insertEndIndex2 : insertEndIndex1;
        int endPos = (insertEndIndex1 == 0) ? 1 : 0;

        int gap = end - start;

        if (gap == 0) {
            intervals.add(new Interval(newInterval.start, newInterval.end));
        } else if (gap == 1) {
            if (startPos == 0 && endPos == 1) {
                intervals.get(start).start = (newInterval.start < intervals.get(start).start) ? newInterval.start : intervals.get(start).start;
                intervals.get(start).end = (newInterval.end > intervals.get(start).end) ? newInterval.end : intervals.get(start).end;
                for (int l = start + 1; l <= end; l++) {
                    intervals.remove(end);
                }
            }

            if (startPos == 0 && endPos == 0) {
                intervals.get(start).start = (newInterval.start < intervals.get(start).start) ? newInterval.start : intervals.get(start).start;
                intervals.get(start).end = (newInterval.end > intervals.get(start).end) ? newInterval.end : intervals.get(start).end;
            }

            if (startPos == 1 && endPos == 0) {
                intervals.get(start).end = (newInterval.end > intervals.get(start).end) ? newInterval.end : intervals.get(start).end;
            }

            if (startPos == 1 && endPos == 1) {
                intervals.get(end).start = (newInterval.start < intervals.get(end).start) ? newInterval.start : intervals.get(end).start;
            }
        } else {
            if (startPos == 0) {
                intervals.get(start).start = (newInterval.start < intervals.get(start).start) ? newInterval.start : intervals.get(start).start;
            }

            if(endPos == 1){
                intervals.get(start).end = (newInterval.end > intervals.get(end).end)?newInterval.end:intervals.get(end).end;
            }
            for (int k = end; k >= start+1; k--) {
                intervals.remove(k);
            }
        }

        return intervals;
    }

    public static ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {

        int start, end;
        int startIndex, endIndex;
        int i;

        start = newInterval.start;
        end = newInterval.end;
        i = 0;

        startIndex = endIndex = -1;

        for (Interval in : intervals) {

            if (start >= in.start && start <= in.end)
                startIndex = i;

            if (end >= in.start && end <= in.end)
                endIndex = i;

            i++;
        }

        if (startIndex == -1 && endIndex == -1) {

            startIndex = 0;

            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }

            endIndex = intervals.size() - 1;

            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }

            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }

            intervals.add(startIndex, newInterval);

            return intervals;
        }

        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }

        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }

        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);

        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;

        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }

        return intervals;

    }

}
