package searching;

public class RabinKarp {
    private String pat; // pattern (only needed for Las Vegas)
    private long patHash; // pattern hash value
    private int M; // pattern length
    private long Q; // a large prime
    private int R = 256; // alphabet size
    private long RM; // R^(M-1) % Q
    public RabinKarp(String pat)
    {
        this.pat = pat; // save pattern (needed only for Las Vegas)
        M = pat.length();
        Q = 997;//longRandomPrime(); // See Exercise 5.3.33.
        RM = 1;
        for (int i = 1; i <= M-1; i++) // Compute R^(M-1) % Q for use
            RM = (R * RM) % Q; // in removing leading digit.
        patHash = hash(pat, M);
    }
    public boolean check(int i) // Monte Carlo (See text.)
    { return true; } // For Las Vegas, check pat vs txt(i..i-M+1).
    private long hash(String key, int M){
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }
    // See text (page 775).
    private int search(String txt)
    { // Search for hash match in text.
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0; // match
        for (int i = M; i < N; i++)
        { // Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (patHash == txtHash)
                if (check(i - M + 1)) return i - M + 1; // match
        }
        return N; // no match
    }

    public static void main(String[] args) {
        String s="FINDINAHAYSTACKNEEDLEINA";
        String pat="NEEDLE";
        RabinKarp r=new RabinKarp(pat);
        System.out.println(r.search(s));
        System.out.println(14159%997);
        double a= ((508 + 3*(997 - 30))*10 + 9);// % 997;
        System.out.println(a);
    }
}
