public class TopPerformerTracker {
    static String findMinMaxSpread(int[] scores) {
        int minimum = scores[0];
        int maximum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minimum) {
                minimum = scores[i];
            }
            if (scores[i] > maximum) {
                maximum = scores[i];
            }
        }
        int spread = maximum - minimum;
        return "Min: " + minimum +" | Max: " + maximum + " | Spread: " + spread;
    }
    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        String result = findMinMaxSpread(scores);
        System.out.println(result);
    }
}