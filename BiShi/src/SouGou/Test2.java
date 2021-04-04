package SouGou;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] patterns = new String[n];
        for(int i =0 ;i < n;i++){
            patterns[i] = sc.nextLine();
        }
        String[] Ips = new String[m];
        for(int i = 0;i < m; i++){
            Ips[i] = sc.nextLine();
        }
        String res = "";
        for(int i = 0; i < Ips.length;i++){
            boolean lock = false;
            for(int j = 0; j < patterns.length;j++){
                String t = "";
                if(patterns[j].charAt(0) == '*'){
                    t = patterns[j].replace("*","");
                    if(Ips[i].endsWith(t)){
                        lock = true;
                        break;
                    }
                }else if(patterns[j].charAt(patterns[j].length()-1) == '*'){
                    t = patterns[j].replace("*","");
                    if(Ips[i].startsWith(t)){
                        lock = true;
                        break;
                    }
                }else{
                    if(patterns[j].equals(Ips[i])){
                        lock = true;
                        break;
                    }
                }
            }
            if(lock) res += "1 ";
            else res += "0 ";
        }
        System.out.println(res.trim());
    }
}

