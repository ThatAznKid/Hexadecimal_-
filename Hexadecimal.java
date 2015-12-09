public class Hexadecimal { 
    private final static String HEXDIGITS = "0123456789ABCDEF"; 
    private int _decNum; 
    private String _hexNum; 
    
    public Hexadecimal() { 
	_decNum = 0; 
	_hexNum = "0"; 
    } 
    
    public String toString() { 
	return _hexNum; 
    } 
    
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
    }
}
