import java.util.ArrayList;

public class BigNumber{

    private String sX;
    private String total = "";
    private int carry = 0;

    private ArrayList<String> num1 = new ArrayList<String>();
    private ArrayList<String> num2 = new ArrayList<String>();
    private ArrayList<Integer> num3 = new ArrayList<Integer>();
    private ArrayList<Integer> num4 = new ArrayList<Integer>();

    public BigNumber(String str) {
        sX = str;
    }

    public String getBN() {
        return sX;
    }

    public BigNumber add(BigNumber y) {
        // Get the string
        String sY = y.getBN();
        // Populate ArrayLists num1 and num2 with the strings backwards
        for(int i = sX.length() - 1; i >= 0; i--) {
            num1.add(sX.charAt(i) + "");
        }
        for(int i = sY.length() - 1; i >= 0; i--) {
            num2.add(sY.charAt(i) + "");
        }
        // Make the ArrayLists the same size, if they aren't already
        if(num2.size() > num1.size()) {
            for(int i = num2.size() - num1.size(); i > 0 ; i--) {
                num1.add("0");
            }
        } else if (num1.size() > num2.size()) {
            for(int j = num1.size() - num2.size(); j > 0; j--) {
                num2.add("0");
            }
        }

        // Add the ArrayLists together into a new ArrayList.
        // First parse integers into temporary variables, then add the temp variables together with carry
        // Divide the number by 10 to see if there is a remainder to be carried. Then modulus the number by 10 to take off the 0.
        for(int i = 0; i < num2.size(); i++) {
            int temp1 = Integer.parseInt(num1.get(i));
            int temp2 = Integer.parseInt(num2.get(i));
            num3.add(i, (temp1 + temp2 + carry));
            carry = num3.get(i)/10;
            num3.set(i, num3.get(i)%10);
        }
        // If by the end there is still a number left to be carried, then add it.
        if(carry > 0) {
            num3.add(carry);
        }
        // Populate a 4th ArrayList by reversing the num3 ArrayList
        for(int i = num3.size() - 1; i >= 0; i--) {
            num4.add(num3.get(i));
        }
        // Take the num4 ArrayList and turn it into a String.
        for(int i = 0; i < num4.size(); i++) {
            total = total + ("" + num4.get(i));
        }
        // Return the total.
        BigNumber z = new BigNumber(total);
        return z;
    }
}