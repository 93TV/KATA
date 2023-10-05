import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * KATA : AnagrammenTest
 *
 * @author kiana
 * @version 05/10/2023
 */
class AnagrammenTest {
    Anagrammen a;

    AnagrammenTest(){
        a = new Anagrammen();
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isLengteGelijk(){
        assertTrue(a.isLengteGelijk("Kiana", "Joris"));
        assertFalse(a.isLengteGelijk("Kiana", "Frederic"));
    }


    @Test
    void isAnagram() {
        assertTrue(a.isAnagram("Laptop machines", "Apple Macintosh"));
        assertFalse(a.isAnagram("Lap machines", "Apple Macintosh"));
        assertThrows(IllegalArgumentException.class, () -> {a.isAnagram("" , "Kiana");});
    }

    @Test
    void checkOpLeestekens(){
        assertTrue(a.isLengteGelijk(a.verwijderLeestekens("Apple Macintosh!!"), "Apple Macintosh"));
        assertTrue(a.isAnagram(a.verwijderLeestekens("Apple Macintosh!!"), "Apple Macintosh"));
        assertFalse(a.isAnagram(a.verwijderLeestekens("Apple Macintoshe!!"), "Apple Macintosh"));
    }

    @ParameterizedTest
    @CsvSource({
            "listen, silent, true",
            "triangle, integral, true",
            "debit card, bad credit, true",
            "cinema, iceman, true",
            "evil, vile, true",
            "hello, world, false",
            "moon, stars, false"
    })
    public void testAreAnagrams(String word1, String word2, boolean expected) {
        Anagrammen a = new Anagrammen();
        boolean result = a.isAnagram(word1, word2);
        assertEquals(expected, result);
    }



}