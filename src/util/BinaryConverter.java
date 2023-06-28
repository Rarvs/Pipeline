package util;

public class BinaryConverter {
    public static String convertToBinary(int number, int numBits) {
        StringBuilder binary = new StringBuilder();

        for (int i = numBits - 1; i >= 0; i--) {
            int bit = (number >> i) & 1;
            binary.append(bit);
        }

        return binary.toString();
    }
}