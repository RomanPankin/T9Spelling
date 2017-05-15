/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonemessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Roman Pankin
 */
public class PhoneMessage {
    private static final int MAX_CASES = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Read amount of messages
        int messagesCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print( "Please enter amount of messages: ");
            String line = br.readLine();

            try {
                messagesCount = Math.min( Integer.parseInt(line), MAX_CASES );
            } catch ( Throwable e ) {
            }
        } while ( messagesCount <= 0 );

        // Read message
        System.out.println();

        for ( int I=0; I<messagesCount; I++ ) {
            System.out.print( (I+1) + ": ");
            String line = br.readLine();

            System.out.print( "Result: " );
            System.out.println( PhoneConvertor.messageToNumbers( line ) );
            System.out.println();
        }

        // Done
        System.out.println( "Good bye" );
    }
}
