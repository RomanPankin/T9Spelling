/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonemessage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roman Pankin
 */
public class PhoneConvertor {
    private static final String DELAY_LETTER = " ";
    private static final String SPACE_LETTER = "0";
    private static final int MAX_LETTERS = 1000;
    
    /// Table of correspondence
    private static final Map<String, String> LETTERS_MAP = new HashMap<String, String>() {{
        put("A","2");
        put("B","22");
        put("C","222");
        put("D","3");
        put("E","33");
        put("F","333");
        put("G","4");
        put("H","44");
        put("I","444");
        put("J","5");
        put("K","55");
        put("L","555");
        put("M","6");
        put("N","66");
        put("O","666");
        put("P","7");
        put("Q","77");
        put("R","777");
        put("S","7777");
        put("T","8");
        put("U","88");
        put("V","888");
        put("W","9");
        put("X","99");
        put("Y","999");
        put("Z","9999");
    }};
    
    /**
     * Converts message into number representation
     * 
     * @param message
     * @return 
     */
    public static String messageToNumbers( String message ) {
        if ( message == null || message.length() == 0 ) return "";

        StringBuilder result = new StringBuilder();
        int len = Math.min( message.length(), MAX_LETTERS );
        
        String prevText = null;
        String text = null;
        
        for ( int I=0; I<len; I++ ) {
            char cChar = Character.toUpperCase( message.charAt(I) );
            if ( cChar == ' ' ) {
                text = SPACE_LETTER;
                
            } else {
                if ( cChar < 'A' || cChar > 'Z' ) continue;
                text = LETTERS_MAP.get( String.valueOf(cChar) );
            }
            
            if ( text != null ) {
                if ( prevText != null && prevText.charAt(0) == text.charAt(0) )
                    result.append( DELAY_LETTER );

                result.append(text);
            }

            prevText = text;
        }
        
        return result.toString();
    }
}
