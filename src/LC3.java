class LC3 {
    public static void main(String[] args) {
        String input = "ycsafxxybcusgjwmfklkfgidgcfzbtdftjxeahriir";
        System.out.println(longestPalindrome(input));
    }
    public static String longestPalindrome(String s) {
        int size = s.length();
        int dp[][] = new int[size][size];

        int len = 1;
        int maxI=0;
        int maxJ=0;
        boolean isEven=false;
        StringBuilder sb;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if(i<j){
                    if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] > 0)) {
                        dp[i][j] = dp[i + 1][j - 1] +2;
                    } else if (s.charAt(i) == s.charAt(j) && (dp[i][j-1] == 1)) {
                        dp[i][j] = 2;
                        isEven=true;
                    } else {
                        dp[i][j] = 0;
                    }

                }
                if ( len<dp[i][j]||(  len==dp[i][j] && j>maxJ ) ){

                    len = dp[i][j];
                    maxI= i;
                    maxJ=j;

                }

            }

        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(maxI+ "   "+ maxJ);

        if(dp[maxI][maxJ]==1){

            sb= new StringBuilder("");
            sb.append(s.charAt(maxJ));

        }else{
            sb= new StringBuilder("");
            while(dp[maxI][maxJ]>1){
                sb.append(s.charAt(maxJ));
                maxI++;
                maxJ--;
            }
            System.out.println(sb.toString());
            if(dp[maxI][maxJ]!=0){
                String half = sb.toString();
                sb.reverse();
                sb.insert(0,s.charAt(maxJ));
                sb.insert(0,half);
            }else{
                String half = sb.toString();
                sb.reverse();
                sb.insert(0,half);
            }

        }

        return sb.toString();
    }
}
