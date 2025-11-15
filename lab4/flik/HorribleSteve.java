package flik;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        Integer i = 0;
        Integer j = 0;
        while (i < 500) {
            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
            i++;
            j++;
        }
        System.out.println("i is " + i);
//        for (int j = 0; i < 500; ++i, ++j) {
//            if (!Flik.isSameNumber(i, j)) {
//                throw new Exception(
//                        String.format("i:%d not same as j:%d ??", i, j));
//            }
//        }
//        System.out.println("i is " + i);
    }
}
