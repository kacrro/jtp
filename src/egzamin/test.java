//package egzamin;
//
//// Plik: D.java
//
//// (1) Klasa C – pakietowa, z polem 'a' i metodą 'mt'
//public class C {
//    int a = 3;
//
//    public int mt(int x) {
//        return (--a) * x;
//    }
//}
//
//// (2) Publiczna klasa D – dziedziczy po C, dodaje własną 'm' i main()
//public class D extends C {
//    public int mt(int x) {
//        this.a++;
//        return this.a * (++x);
//    }
//
//    public static void main(String[] args) {
//        C o = new D();      // tworzysz obiekt typu D, referencja C
//        int x = 7;
//
//        System.out.println("o.a = "    + o.a);      // dostęp do pola a z C
//        System.out.println("o.mt(x) = " + "" + o.mt(x)); // wywołuje C.mt()
//        System.out.println("x = "       + x);       // x niezmienione
//        System.out.println("o.a = "    + o.a);      // pole a zostało zaktualizowane przez mt()
//    }
//}