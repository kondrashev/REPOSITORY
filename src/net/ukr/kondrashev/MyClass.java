package net.ukr.kondrashev;

public class MyClass {
    @Test(paramOne = 2, paramTwo = 5)
    public int result(int a, int b) {
        int res = 0;
        return res = a + b;
    }
}
