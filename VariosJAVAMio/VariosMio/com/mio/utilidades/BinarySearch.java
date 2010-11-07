package com.mio.utilidades;

public class BinarySearch
{
    /**
     * Performs the standard binary search
     * using two comparisons per level.
     * @exception ItemNotFound if appropriate.
     * @return index where item is found.
     */
    public static int binarySearch( Comparable [ ] a, Comparable x )
                                    throws Exception
    {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while( low <= high )
        {
            mid = ( low + high ) / 2;

            if( a[ mid ].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[ mid ].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;
        }

        throw new Exception( "BinarySearch fails" );
    }

    // Test program
    public static void main( String [ ] args )
    {
        int SIZE = 8;
        Comparable [ ] a = new Integer [ SIZE ];
        for( int i = 0; i < SIZE; i++ )
            a[ i ] = new Integer( i * 2 );

        for( int i = 0; i < SIZE * 2; i++ )
        {
            try
            {
                System.out.println( "Found " + i + " at " +
                                     binarySearch( a, new Integer( i ) ) );
            }
            catch( Exception e )
              { System.out.println( i + " not found" ); }
        }
    }
}