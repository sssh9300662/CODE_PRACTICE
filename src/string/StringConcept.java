package string;

public class StringConcept {

    public static void main(String[] args){
        String a = "String";
        String b = "String";
        String c = new String("String");

        System.out.println(a == b); // https://www.delftstack.com/zh-tw/howto/java/java-string-equals-vs-/
        System.out.println(a == c); // different object
    }
}
