import java.util.*;

class BEEC1055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = 1;
        while (n-- > 0) {
            System.out.print("Case " + c++ + ": ");
            int q = scanner.nextInt();
            List<Integer> resp = new ArrayList<>();
            while (q-- > 0) {
                int r = scanner.nextInt();
                resp.add(r);
            }
            Collections.sort(resp);
            int t = 0, x = 0, y = resp.size() - 1;
            Deque<Integer> ans = new ArrayDeque<>();
            while (t < resp.size()) {
                if (ans.isEmpty())
                    ans.add(resp.get(y--));
                else {
                    PriorityQueue<iii> pq = new PriorityQueue<>(Collections.reverseOrder());
                    pq.add(new iii(new ii(Math.abs(resp.get(x) - ans.peekFirst()), 1), x));
                    pq.add(new iii(new ii(Math.abs(resp.get(x) - ans.peekLast()), 2), x));
                    pq.add(new iii(new ii(Math.abs(resp.get(y) - ans.peekFirst()), 3), y));
                    pq.add(new iii(new ii(Math.abs(resp.get(y) - ans.peekLast()), 4), y));
                    iii top = pq.poll();
                    if (top.first.second == 1) {
                        ans.addFirst(resp.get(top.second));
                        x++;
                    } else if (top.first.second == 2) {
                        ans.addLast(resp.get(top.second));
                        x++;
                    } else if (top.first.second == 3) {
                        ans.addFirst(resp.get(top.second));
                        y--;
                    } else {
                        ans.addLast(resp.get(top.second));
                        y--;
                    }
                }
                t++;
            }
            int sum = 0;
            Iterator<Integer> iterator = ans.iterator();
            int prev = iterator.next();
            while (iterator.hasNext()) {
                int current = iterator.next();
                sum += Math.abs(prev - current);
                prev = current;
            }
            System.out.println(sum);
        }
    }

    static class ii implements Comparable<ii> {
        int first, second;

        public ii(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(ii other) {
            if (this.first != other.first)
                return Integer.compare(this.first, other.first);
            return Integer.compare(this.second, other.second);
        }
    }

    static class iii implements Comparable<iii> {
        ii first;
        int second;

        public iii(ii first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(iii other) {
            return this.first.compareTo(other.first);
        }
    }
}
