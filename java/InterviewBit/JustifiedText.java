package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shyamsunderpandita on 26/11/16.
 */
public class JustifiedText {

    // CORRECT APPROACH - All Test Cases Passed in interviewbit
    public static ArrayList<String> fullJustifyNewApproach(ArrayList<String> a, int b) {
        ArrayList<String> output = new ArrayList<String>();

        for(int i = 0 ; i< a.size(); i++){
            int l = 0;
            StringBuilder builder = new StringBuilder();
            int words = 0;
            while(i<a.size() && l < b){

                if(l < b){
                    builder.append(a.get(i));
                    words++;
                }

                l+=a.get(i).length();

                if(i+1 < a.size() && (a.get(i+1).length() + l) < b){

                    l++; // for extra space between words
                    builder.append(" ");

                }
                else {
                    break;
                }
                i= i+1;
            }

            int len = builder.length();

            // Adding extra spaces in between if len is less than b
            if(len < b && i < a.size()) {
                //Add logic for 1 word in last line case
                if (!(builder.toString().contains(" "))) {
                    int remaining = b - len;
                    for (int j = 0; j < remaining; j++) {
                     builder.append(" ");
                    }
                    output.add(builder.toString());

                } else {
                    int remaining = b - len;
                    int[] spaceCount = new int[words - 1];
                    while (remaining > 0) {
                        for (int c = 0; c < spaceCount.length; c++) {
                            if (remaining <= 0) {
                                break;
                            }
                            spaceCount[c] = spaceCount[c] + 1;
                            remaining--;
                        }
                    }

                    //adding spaces in between
                    int count = 0;
                    StringBuilder newSpaceBuilder = new StringBuilder();
                    for (int j = 0; j < builder.length(); j++) {
                        newSpaceBuilder.append(builder.charAt(j));
                        if (builder.charAt(j) == ' ' && count < words - 1) {
                            for (int k = 0; k < spaceCount[count]; k++) {
                                newSpaceBuilder.append(" ");
                            }
                            count++;
                        }
                    }

                    output.add(newSpaceBuilder.toString());
                }
            }
            else{
                output.add(builder.toString());
            }

        }

        // For handling special case of last line
        if(output.size() >0) {
            String[] lastLine = output.get(output.size() - 1).split("\\s+");
            StringBuilder last = new StringBuilder();
            int d;

            for (d = 0; d < lastLine.length - 1; d++) {
                last.append(lastLine[d]);
                last.append(" ");
            }

            last.append(lastLine[d]);

            int remaining = b- last.length();
            for(int j = 0 ; j < remaining ; j++){
                last.append(" ");
            }

            output.set(output.size() - 1, last.toString());
        }
        return output;
    }


    public static void main(String... args){
        ArrayList<String> list = new ArrayList<>();
        list.add("what");
        list.add("must");
        list.add("be");
        list.add("shall");
        list.add("be.");

        System.out.println(fullJustifyNewApproach(list,12));

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("This");
        list2.add("is");
        list2.add("an");
        list2.add("example");
        list2.add("of");
        list2.add("Text");
        list2.add("Justification");

        System.out.println(fullJustifyNewApproach(list2,16));

        String[] l3 = new String []{ "zoea", "cmdw", "l", "bxcyofzw", "jwzr", "kwjpyevjxq", "queigj", "xf", "abighmqbtf", "txjysly", "fqcxvxokgm", "uc", "fefqtpkd", "ctbv", "pmgrbggjq", "henz", "zubxjlxodp", "yhxhl", "rii", "rxribedfv", "tywrhilgsb", "xz" };
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(l3));
        System.out.println(fullJustifyNewApproach(list3,36));

        String[] l4 = new String [] { "tv", "izln", "dkq", "ypbbix", "k", "xoojn", "xju", "xfe", "aysz", "agkfhvtqkt", "rsklvgn", "kedzohp", "lqzz", "hivu", "gtxrjj", "nz", "ysoatq", "n", "ote", "xuctw", "vlvgmfzm", "zlpmp", "oe", "kayhyihc", "yvsllceili", "osqkjjvydc", "p", "zxqrgyvnic", "ebxhww", "pyjdlt", "ruwl", "lnlt", "ddzf", "jicwez", "mcrj", "unbej", "on", "thivo", "sbzxsxvm", "jj", "lacb", "qfsopsmeq", "ial", "tifiuf", "uybh", "pcbufc", "nccdldzs", "pbsofijlmp", "ehdcxkgbi", "wu", "gvnzmw", "czonuzrls", "blg", "y", "qbdgiwboi", "wpeupcwz", "fxnbh", "sybikok", "ukuztzdqk", "oowhjnhol", "s", "kvmtoutvf", "ilh", "q", "tclbqcdbz", "oglfrq", "cwtucyecf", "am", "kflhesgk", "xnxpogj", "nx", "hwfb", "htmf", "xawcimlx", "hhivdgf", "uk", "evtsczh" };
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList(l4));
        System.out.println(fullJustifyNewApproach(list4,483));
    }
}
