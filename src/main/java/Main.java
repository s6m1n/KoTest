//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 입력 처리
//        String[] input = scanner.nextLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
//
//        // 제목과 값 저장
//        List<Pair<Integer, String>> title = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            String[] line = scanner.nextLine().split(" ");
//            String name = line[0];
//            int power = Integer.parseInt(line[1]);
//            title.add(new Pair<>(power, name));
//        }
//
//        // 쿼리 처리
//        for (int i = 0; i < M; i++) {
//            int power = Integer.parseInt(scanner.nextLine());
//            System.out.println(check(power, title));
//        }
//    }
//
//    public static String check(int power, List<Pair<Integer, String>> title) {
//        int start = 0;
//        int end = title.size() - 1;
//        int p = start + (end - start) / 2;
//
//        while (start < end) {
//            if (power == title.get(p).getFirst()) {
//                break;
//            } else if (power < title.get(p).getFirst()) {
//                if (p > 0 && title.get(p - 1).getFirst() < power) {
//                    break;
//                } else {
//                    end = p - 1;
//                }
//            } else { // power > title.get(p).getFirst()
//                start = p + 1;
//            }
//            p = start + (end - start) / 2;
//        }
//
//        return title.get(p).getSecond();
//    }
//
//    // Pair 클래스 구현
//    public static class Pair<K, V> {
//        private final K first;
//        private final V second;
//
//        public Pair(K first, V second) {
//            this.first = first;
//            this.second = second;
//        }
//
//        public K getFirst() {
//            return first;
//        }
//
//        public V getSecond() {
//            return second;
//        }
//    }
//}
