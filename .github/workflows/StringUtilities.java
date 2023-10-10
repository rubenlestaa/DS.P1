package e1;

import java.lang.reflect.Array;

public class StringUtilities {
    public static boolean isValidString(String str, String validChar, int minLenght) {
        if(str==null) return false;
        if (!str.isEmpty() && str.length() >= minLenght) {
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (!Character.isDigit(c) && -1 == validChar.indexOf(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String lowercaseFirst(String str) {
        if (!str.isEmpty()) {
            StringBuilder minusculas = new StringBuilder();
            StringBuilder mayusculas = new StringBuilder();
            StringBuilder otrosCaracteres = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char letraActual = str.charAt(i);
                if (Character.isLowerCase(letraActual)) minusculas.append(letraActual);
                else if (Character.isUpperCase(letraActual)) mayusculas.append(letraActual);
                else otrosCaracteres.append(letraActual);
            }
            minusculas.append(mayusculas);
            System.out.println(minusculas);
            System.out.println(otrosCaracteres);
            return minusculas.toString();
        }
        return str;
    }

    public static boolean checkTextStats(String frase, int minLength, int maxLength){
        if (frase==null || frase.isEmpty() || frase.isBlank() || maxLength <= 0 || minLength <= 0) {
            throw new IllegalArgumentException("El texto de entrada no es valido o los limites son negativos");
        }
        else {
            String[] words = frase.split(" ");
            int longestLength = 0;
            int j=Array.getLength(words);
            int sumLength=0;
            for (int i=0 ; i<j ; i++){
                int currentLength = words[i].length();
                sumLength+=currentLength;
                if (currentLength>longestLength) longestLength=currentLength;
            }
            float media = (float)sumLength/(float)j;
            return minLength <= media && maxLength >= media && longestLength <= 2 * media;
        }
    }
}
