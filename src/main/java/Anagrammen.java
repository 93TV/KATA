import java.util.Arrays;

/**
 * KATA : Anagrammen
 *
 * @author kiana
 * @version 05/10/2023
 */
public class Anagrammen {

    public Anagrammen() {
    }

    public boolean isAnagram(String woord1, String woord2){
        if (woord1.length() == 0 || woord2.length() == 0)
            throw new IllegalArgumentException("Gelieve een woord in te vullen");
        woord1 = verwijderLeestekens(woord1);
        woord2 = verwijderLeestekens(woord2);

        if (!isLengteGelijk(woord1, woord2))
            return false;

        char[] charArray1 = woord1.toCharArray();
        char[] charArray2 = woord2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public String verwijderLeestekens(String woord) {
        return woord.replaceAll( "[^\\sa-zA-Z0-9]", "" ).toLowerCase();
    }

    public boolean isLengteGelijk(String woord1, String woord2){
        woord1 = woord1.replace(" ", "");
        woord2 = woord2.replace(" ", "");
        return woord1.length() == woord2.length();
    }

}
