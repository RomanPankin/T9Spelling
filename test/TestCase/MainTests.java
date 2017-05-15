/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCase;

import java.util.Arrays;
import phonemessage.PhoneConvertor;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roman Pankin
 */
public class MainTests {
    
    public MainTests() {
    }
    
    @Test
    public void emptyMessage() {
        assertEquals( PhoneConvertor.messageToNumbers( "" ), "" );
        assertEquals( PhoneConvertor.messageToNumbers( null ), "" );
    }

    @Test
    public void sampleMessages() {
        assertEquals( PhoneConvertor.messageToNumbers( "hi" ), "44 444" );
        assertEquals( PhoneConvertor.messageToNumbers( "yes" ), "999337777" );
        assertEquals( PhoneConvertor.messageToNumbers( "foo  bar" ), "333666 6660 022 2777" );
        assertEquals( PhoneConvertor.messageToNumbers( "hello world" ), "4433555 555666096667775553" );
    }
    
    @Test
    public void wrongMessage() {
        assertEquals( PhoneConvertor.messageToNumbers( "a99" ), "2" );
    }
    
    @Test
    public void longMessage() {
        char[] chars = new char[1010];
        Arrays.fill(chars, 'A');
        String text = new String(chars);
        
        StringBuilder expected = new StringBuilder(1000);
        for( int I=0; I<1000; I++ )
            expected.append( I == 999 ? "2" : "2 " ); 
        
        assertEquals( PhoneConvertor.messageToNumbers( text ), expected.toString() );
    }
    
    @Test
    public void lowerAndUpper() {
        assertEquals( PhoneConvertor.messageToNumbers( "yes" ), "999337777" );
        assertEquals( PhoneConvertor.messageToNumbers( "YeS" ), "999337777" );
    }
}
