package week;

import java.util.HashMap;

public class NumEquivDominoPairs {
    public static void main(String[] args) {
        NumEquivDominoPairs numEquivDominoPairs = new NumEquivDominoPairs();
        int [][] numss = {{1,2},{2,1},{3,4},{5,6},};
        numEquivDominoPairs.numEquivDominoPairs(numss);
    }
    class Pairs {
        int a,b;
        Pairs(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public boolean equals(Object obj) {
            if (a == ((Pairs)obj).a && b == (((Pairs) obj).b)) {
                return true;
            }

            if (a == ((Pairs)obj).b && b == (((Pairs) obj).a)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            if (a > b) {
                return a*10+b;
            } else {
                return b*10+a;
            }
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Pairs, Integer> hashMap = new HashMap<>(dominoes.length);

        for (int i = 0; i < dominoes.length; i++) {
            Pairs pairs = new Pairs(dominoes[i][0], dominoes[i][1]);
             if (hashMap.containsKey(pairs)) {
                 hashMap.put(pairs, hashMap.get(pairs)+1);
             } else {
                 hashMap.put(pairs, 0);
             }
        }
        int sum = 0;
        for (int value : hashMap.values()) {
            int c = 0;
            for (int count = 0; count <= value; count++) {
                c+=count;
            }
            sum+=value;
        }
        return sum;
    }
}
