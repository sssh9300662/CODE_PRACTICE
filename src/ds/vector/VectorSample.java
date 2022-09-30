package ds.vector;

import java.util.Vector;

public class VectorSample {

    public static void main(String args[]) {
        Vector v = new Vector();
        v.addElement(12);
        v.addElement(34L);
        v.addElement(5.6f);
        v.addElement(7.8);
        v.addElement(new String("Hello"));

        for (int i = 0 ; i < v.size() ; i++){
            Object obj = v.elementAt(i);
            System.out.println(obj);
        }
    }
}
