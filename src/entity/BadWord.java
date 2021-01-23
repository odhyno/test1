package entity;

import utility.BadWordFormatter;
import utility.WordWeight;

/**
 *  Entità relativa alle parole non consentite
 *  @author Beccarini Luca, Ludovisi Linda, Paci Andrea
 *  @version 1.0
 */
public class BadWord
{
    private String word;
    private WordWeight wordWeight;

    public BadWord(String word, WordWeight wordWeight)
    {
        this.word = word;
        this.wordWeight = wordWeight;
    }


    //Mi ritorna la parola con la formattazione badWord - Gravità


    public String getBadWordFormatted()
    {
        return BadWordFormatter.getStartWord() +
                word +
                BadWordFormatter.getEndWord() +
                BadWordFormatter.getStringFromEnum(wordWeight);
    }

    public String getWord() { return word; }

    public void setWord(String word) { this.word = word; }

    public WordWeight getWordWeight() { return wordWeight; }

    public void setWordWeight(WordWeight wordWeight) { this.wordWeight = wordWeight; }
}
