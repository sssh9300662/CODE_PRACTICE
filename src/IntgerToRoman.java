

public class IntgerToRoman {

    public IntgerToRoman() {
        // TODO Auto-generated constructor stub
    }

    public String intToRoman(int num) {
        // Two arrays for mapping
        int arrInteger[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String arrString[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String ans = "";
        int i = 0;
        while (num > 0) {
            while (num - arrInteger[i] < 0) {//less than current index value so move to next
                i++;
            }
            ans = ans + arrString[i];
            num = num - arrInteger[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        IntgerToRoman obj = new IntgerToRoman();
        System.out.println(obj.intToRoman(13958));
    }

}
