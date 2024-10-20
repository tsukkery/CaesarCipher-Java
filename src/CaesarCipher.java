public class CaesarCipher {

    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void Encipher(String text, int shift) {

        char[] message = text.toCharArray();

        String result = "";

        for (char c : message) {
            String a = Character.toString(c).toLowerCase();
            if (c < 65 || c > 122)
                result += (Character.toString(c));
            else if (alphabet.contains(a)) {

                if (a.equals(Character.toString(c)))
                    result += (Character.toString(alphabet.charAt(move(shift, alphabet, a))));
                else
                    result += (Character.toString(alphabet.charAt(move(shift, alphabet, a))).toUpperCase());
            }
        }
        System.out.println(result);
    }

    private static int move(int shift, String alphabet, String a) {
        shift = mod(shift, alphabet.length());
        int move = shift - (alphabet.length() - alphabet.indexOf(a));
        if (move < 0) {
            move = alphabet.length() + move;
        }
        return move;
    }

    private static int mod(int shift, int length) {
        return shift >= 0 ? shift % length : (length + shift % length) % length;
    }
}
