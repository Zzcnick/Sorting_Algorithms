/* Zicheng Zhen
   Sorting Algorithms - APCS1 pd10 */

import java.util.*;

public class MySorts {
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    //check if arraylist is sorted
    public static boolean isSorted( ArrayList<Comparable> al )
    {
	for (int i = 0; i < al.size()-1; i++) {
	    if (al.get(i).compareTo(al.get(i+1)) > 0) {
		return false;
	    }
	}
	return true;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Sorting Algorithms
    // =====================================================
    // BubbleSort - O(n^2)
    // =====================================================
    public static void bubbleSort(ArrayList<Comparable> L) {
	int check = 0; // When to end
	for (int loops = 0; loops < L.size()-1; loops++) {
	    for (int i = L.size()-1; i > check; i--) {
		if (L.get(i).compareTo(L.get(i-1)) < 0)
		    L.set(i-1, L.set(i, L.get(i-1)));
	    }
	}
    }
    public static ArrayList<Comparable> bubbleSorted(ArrayList<Comparable> L) {
        ArrayList<Comparable> out = new ArrayList<Comparable>(L);
	bubbleSort(out);
	return out;
    }
    // =====================================================
    // SelectionSort - O(n^2)
    // =====================================================
    public static void selectionSort(ArrayList<Comparable> L) {
	for (int passes = 0; passes < L.size()-1; passes++) {
	    int curLow = passes; // Lowest Element Index
	    for (int i = passes; i < L.size(); i++) {
		if (L.get(i).compareTo(L.get(curLow)) < 0) // If lower
		    curLow = i; // Keeps Track of the Current Lowest
	    }
	    // After getting current low, swap with the element at the front
	    L.set(passes, L.set(curLow, L.get(passes)));
	}
    }
    public static ArrayList<Comparable> selectionSorted(ArrayList<Comparable> in) {
	ArrayList<Comparable> out = new ArrayList<Comparable>(in);
	selectionSort(out);
	return out;
    }
    // =====================================================
    // BogoSort - O(infinity)
    // =====================================================
    public static void bogoSort(ArrayList<Comparable> L) {
	while (!(isSorted(L))) {
	    shuffle(L);
	}
    }
    public static ArrayList<Comparable> bogoSorted(ArrayList<Comparable> in) {
	ArrayList<Comparable> out = new ArrayList<Comparable>(in);
	bogoSort(out);
	return out;
    }
    // =====================================================
}
