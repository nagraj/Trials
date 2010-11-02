/**
 * 
 */
package formats;

/**
 * @author karthick
 *
 */
import static java.lang.System.out;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Demonstrate the basic use of BigInteger
 *
 * @author Roedy Green, Canadian Mind Products
 * @version 1.0, 2006-02-28
 */
public class BigInt {
// --------------------------- main() method ---------------------------

    /**
     * Test BigInteger
     *
     * @param args not used
     */
    public static void main( String[] args )
        {
        BigInteger a = new BigInteger( "1234567890123456789012234" );
        BigInteger b = new BigInteger( "-12345" );
        BigInteger c = a.add( b );
        out.println( a );
        c = c.multiply( BigInteger.TEN );
        out.println( c );
        // valueOf for longs is faster than using the constructor
        c = c.divide( BigInteger.valueOf( 1024 ) );
        out.println( c );

        // generate a suitable value for private key encryption
        // 1024 bits long, probably prime.
        BigInteger p = new BigInteger( 1024
                                       /* size in bits */,
                                       100
                                       /* 1 in 100 chance not prime */,
                                       new SecureRandom() );

        // chaining operations
        BigInteger d = BigInteger.valueOf( 7 )
                .modInverse( p.subtract( BigInteger.ONE ) );
        out.println( d );

        // exporting to a byte array
        byte[] dbytes = d.toByteArray();
        }
}
