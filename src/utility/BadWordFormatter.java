package utility;


import static utility.WordWeight.*;

/**
 *  Classe di utility per la formattazione
 *  delle parole non consentite
 *  @author Beccarini Luca, Ludovisi Linda, Paci Andrea
 *  @version 1.0
 */
public abstract class BadWordFormatter
{
    private static final char START_WORD = '.';
    private static final char END_WORD = '-';

    public static String getStringFromEnum(WordWeight wordWeight)
    {
        switch (wordWeight)
        {
            case LIEVE:
                return "L";


            case MEDIA:
                return "M";


            case GRAVE:
                return "G";


            case BANDITA:
                return "B";


            default:
                return null;

        }
    }

    public static WordWeight getEnumFromString(String wordWeight)
    {
        switch (wordWeight)
        {
            case "L":
                return LIEVE;


            case "M":
                return MEDIA;


            case "G":
                return GRAVE;


            case "B":
                return BANDITA;


            default:
                return null;

        }
    }


    public static char getStartWord() { return START_WORD; }

    public static char getEndWord() { return END_WORD; }
}
