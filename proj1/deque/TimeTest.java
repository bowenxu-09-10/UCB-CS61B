package deque;

import edu.princeton.cs.algs4.Stopwatch;

public class TimeTest {

    public static void printTimingTable(LinkedListDeque<Integer> ns,
                                        LinkedListDeque<Double> times,
                                        LinkedListDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < ns.size(); i += 1) {
            int N = ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    /**
     * Compute the time of LinkedListDeque addLast n times
     */
    public static void timeCompute(int n, LinkedListDeque<Integer> ns,
                                   LinkedListDeque<Double> times,
                                   LinkedListDeque<Integer> opCounts) {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        for (int i = 0; i < n; i++) {
            lst.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < n; i++) {
            lst.removeLast();
        }
        double timeInSenconds = sw.elapsedTime();
        times.addLast(timeInSenconds);
    }
}
