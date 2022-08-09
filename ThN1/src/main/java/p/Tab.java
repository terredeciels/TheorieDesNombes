package p;

public class Tab {
    int N = 32, k;
    int[] tab = new int[(N+1) * (N+1)];

    public Tab() {
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                tab[k++] = i + N * j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= N*N; k++) {
           sb.append(tab[k]).append(",");
           if (tab[k]%N==0) sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Tab();

    }
}
