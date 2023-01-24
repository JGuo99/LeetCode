import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void Decompress1(){
        Decompress decomp = new Decompress();
        String test = "3[abc]4[ab]c";
        assertEquals("abcabcabcababababc", decomp.decompress(test));
    }
    @Test
    public void Decompress2(){
        Decompress decomp = new Decompress();
        String test = "2[3[a]b]";
        assertEquals("aaabaaab", decomp.decompress(test));
    }
    @Test
    public void Decompress3(){
        Decompress decomp = new Decompress();
        String test = "10[a]";
        assertEquals("aaaaaaaaaa", decomp.decompress(test));
    }
}
