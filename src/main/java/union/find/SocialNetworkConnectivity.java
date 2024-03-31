package union.find;

import java.util.Arrays;
import java.util.List;

public class SocialNetworkConnectivity {
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public SocialNetworkConnectivity(int n) {
        weightedQuickUnionUF = new WeightedQuickUnionUF(n);
    }

    public String minTimestampAllConnected(List<String> logFile) {
        for (String line : logFile) {
            String[] split = line.split(" ");
            weightedQuickUnionUF.union(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            if (weightedQuickUnionUF.getComponents() == 1) {
                return split[2];
            }
        }
        return "None";
    }

    public static void main(String[] args) {
        List<String> logFile = Arrays.asList("0 1 2015-08-14T18:00:00",
                "1 9 2015-08-14T18:01:00",
                "0 2 2015-08-14T18:02:00",
                "0 3 2015-08-14T18:04:00",
                "0 4 2015-08-14T18:06:00",
                "0 5 2015-08-14T18:08:00",
                "0 6 2015-08-14T18:10:00",
                "0 7 2015-08-14T18:12:00",
                "0 8 2015-08-14T18:14:00",
                "1 2 2015-08-14T18:16:00",
                "1 3 2015-08-14T18:18:00",
                "1 4 2015-08-14T18:20:00",
                "1 5 2015-08-14T18:22:00",
                "2 1 2015-08-14T18:24:00",
                "2 3 2015-08-14T18:26:00",
                "2 4 2015-08-14T18:28:00",
                "5 5 2015-08-14T18:30:00");
        SocialNetworkConnectivity socialNetworkConnectivity = new SocialNetworkConnectivity(10);
        System.out.println(socialNetworkConnectivity.minTimestampAllConnected(logFile));
    }
}
