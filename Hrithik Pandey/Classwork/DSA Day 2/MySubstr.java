public class MySubstr {
    static boolean subS(String a, String b) {
        int j ;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                for (j = 0; j < b.length(); j++) {
                    if (a.charAt(i + j) != b.charAt(j))
                        break;
                    if (j == b.length() - 1) {
                        System.out.println(i);
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
