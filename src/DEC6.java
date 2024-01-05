// https://adventofcode.com/2023/day/6
// **

public class DEC6 {
    public static void main(String[] args) throws Exception{
        //Lists for dealing woth first gold star
        int[] lst_time = {54, 94, 65, 92};
        int[] lst_dist = {302, 1476, 1029, 1404};
        long wins_multi = 1L;

        //Checks number of ways to win for each value in array
/*         for (int a = 0; a < lst_time.length; a++) {
            //multiplies ways to win
            wins_multi *= get_wins(lst_time[a], lst_dist[a]);
            
        } */
        wins_multi *= get_wins(54946592L, 302147610291404L);
        System.out.println(wins_multi);
    }
    //checks if (time - a) * a) is larger than distance
    //for each combination of time and a.
    //returns the number of ways to win
    static long get_wins(long time, long dist) {
        long wins = 0L;

        for (long a = 0L;a <= time; a++) {
            if (((time - a) * a) > dist) {
                wins += 1;
            }
        }
        return wins;
    }
    
}