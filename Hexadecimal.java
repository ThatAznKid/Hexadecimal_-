public class Hexadecimal { 
    private final static String HEXDIGITS = "0123456789ABCDEF"; 
    private int _decNum; 
    private String _hexNum; 
    
    public Hexadecimal() { 
	_decNum = 0; 
	_hexNum = "0"; 
    } 
    
    public Hexadecimal (int n) { 
	_decNum = n; 
	_hexNum = decToHex(n); 
    } 

    public Hexadecimal (String s) { 
	_decNum = hexToDec (s); 
	_hexNum = s; 
    }

    public String toString() { 
	return _hexNum; 
    } 
    /*
    public static String decToHex (int n) { 
        int holder = 0; 
	int holder2 = 0;
	int number = n;
	int count = 0;
	String retStr = "";
	while (number != 0) {
	    while (holder < number) { 
		count = count + 1;
		holder = (int)(Math.pow (16,count));
	    }
	    holder = (int)(Math.pow (16,count-1)); 
	    count = 0;
	    holder2 = holder;
	    holder = number / holder; 
	    number = number % holder2;
	    if (holder < 10) {
		retStr = retStr + holder;
	    }
	    else {
		retStr = retStr + HEXDIGITS.substring (holder,holder+1);
	    }
	}
	return retStr;
	
    } 

    public static int hexToDec (String s) { 
	int holder = s.length();
	int holder2 = 0;
	int total = 0;
	for (int x = 0; x < s.length(); x++){
	    holder2 = HEXDIGITS.indexOf (s.substring (holder-1,holder));
	    total = total + (int)(Math.pow (16,x) * holder2);
	    holder = holder - 1;
	}
	return total; 
    }
*/
    public static String decToHex( int n ) {
	String retStr="";
	while (n>0){
	    retStr=HEXDIGITS.substring(n%16,n%16+1)+retStr;//Adds remainder to string
	    n=n/16;//Sets n equal to quotient
	}
	return retStr;
    }
    public static int hexToDec( String s ) {
	int retInt=0;
	for (int x=0;x<s.length();x++){
	    retInt+=(int)(HEXDIGITS.indexOf(s.substring(x,x+1).toUpperCase())*Math.pow(16,(s.length()-1-x)));//Multiplies each number by its proper power of 16
	}
	return retInt;  
    }
    public int compareTo (Object other) { 
	Hexadecimal cee = (Hexadecimal) other; 
	int theirs = cee._decNum; 
	int ours = this._decNum; 
	if (theirs == ours) { 
	    return 0; 
	} 
	else if (theirs > ours) { 
	    return -1; 
	}
	else { 
	    return 1;
	}
    }

    public boolean equals (Object other) { 
	return (compareTo (other) == 0); 
    }

    public static void main (String[] args) { 
	System.out.println (hexToDec ("1128"));
	System.out.println (hexToDec ("1EF"));
	System.out.println (decToHex (4392));
	System.out.println (decToHex (495));
	
	Hexadecimal h1 = new Hexadecimal (5); 
	Hexadecimal h2 = new Hexadecimal (5); 
	Hexadecimal h3 = new Hexadecimal (7); 
	
	System.out.println ("Printing...");
	System.out.println (h1); 
	System.out.println (h2); 
	System.out.println (h3); 
	
	System.out.println ("They equal?");
	System.out.println (h1 == h2); 
	System.out.println (h1 == h3); 
	
	System.out.println ("Check again if they're equal, man.");
	System.out.println (h1.equals (h2)); 
	System.out.println (h1.equals (h3)); 
	
	System.out.println ("Let's try comparing them...");
	System.out.println (h1.compareTo (h2)); 
	System.out.println (h1.compareTo (h3));
    }
}
