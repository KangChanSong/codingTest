package book;

public class P115 {
    public static void main(String[] args) {
        int[] arr = {6, 4, 1, 2, 1, 9, 8, 0};
        int n = 3;
        arr[arr.length-1] = n;

        int i = 0;
        while (true){
            StringBuilder builder = new StringBuilder();
            for(int k = 0 ; k < i ; k++){
                builder.append("  ");
            }
            builder.append("*");
            System.out.println(builder.toString());
            for(int x = 0 ; x < arr.length-1 ; x++){
                System.out.print(arr[x] + " ");
            }
            System.out.println();

            if(i == arr.length-1) {
                System.out.println(n + " 을 찾지 못했습니다.");
                break;
            }
            if(arr[i] == n){
                System.out.println(n + " 은 arr[" + i + "]에 있습니다." );
                break;
            }
            i++;
        }
    }
}
