package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    @Test
    public void testDecodeVowels() {
        assertEquals("testing", Decoder.decodeVowels("t2st3ng"));
        assertEquals("example", Decoder.decodeVowels("2x1mpl2"));
    }
    @Test
    public void testDecodeConsonants() {
        assertEquals("testing", Decoder.decodeConsonants("uftujoh"));
        assertEquals("example", Decoder.decodeConsonants("fybnqmf"));
    }

    @Test
    public void testDecodeMessage() {
        assertEquals("testing example", Decoder.decodeMessage("t2st3ng 2x1mpl2"));
        assertEquals("hello", Decoder.decodeMessage("h2ll4"));
        assertEquals("world", Decoder.decodeMessage("w4rld"));
    }
}