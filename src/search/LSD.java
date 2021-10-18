package search;

public class LSD {

        public static void sort(String[] a, int W)
        { // Sort a[] on leading W characters.
            int N = a.length;
            int R = 257;
            String[] aux = new String[N];
            for (int d = W-1; d >= 0; d--)
            { // Sort by key-indexed counting on dth char.
                int[] count = new int[R+1]; // Compute frequency counts.
                for (int i = 0; i < N; i++)
                    count[a[i].charAt(d) + 1]++;
                for (int r = 0; r < R; r++) // Transform counts to indices.
                    count[r+1] += count[r];
                for (int i = 0; i < N; i++) // Distribute.
                    aux[count[a[i].charAt(d)]++] = a[i];
                for (int i = 0; i < N; i++) // Copy back.
                    a[i] = aux[i];
            }
        }

    public static void main(String[] args) {
        String a[] ={"4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
               " 1OHV845",
                "4JZY524",
               " 1ICK750",
               " 3CIO720",
               " 1OHV845",
               " 1OHV845",
               " 2RLA629",
               " 2RLA629",
                "3ATW723"};
 System.out.println(a[0].charAt(6));

        sort(a,7);
        for (String s:a
             ) {
            System.out.println(s);
        }

    }

}
