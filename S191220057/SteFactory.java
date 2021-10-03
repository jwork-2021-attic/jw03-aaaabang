package S191220057;

import java.io.IOException;

import example.encoder.SteganographyFactory;

public class SteFactory {

    public static void main (String[] args) throws IOException
    {
        SteganographyFactory.getSteganography("S191220057/QuickSorter.java","S191220057/resource/meme.png");
        SteganographyFactory.getSteganography("S191220057/InsertSorter.java","S191220057/resource/meme.png");
    }
}
