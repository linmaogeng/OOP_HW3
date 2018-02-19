import java.util.Arrays;
/**
 * 
 */

/**
 * @author Students
 *
 */
public class MyString { //In order to finish this project, I have looked over a lot Java API documentation from Oracle.
						//https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo(java.lang.String)
						//https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
						//https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html
						//https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
	
	private final char[] chars;
	private final int length;
	
	public MyString clone() {
		return new MyString(this.chars);
	}
	
	public MyString() {
		chars = new char[0];
		length = 0;
	}

	private MyString(int length) {
		chars = new char[length];
		this.length = length;
	}
	
	public MyString(char[] chars) {
		this.chars = chars.clone();
		length = chars.length;
	}
	
	public MyString(String s) {
		chars = s.toCharArray();
		length = chars.length;
	}
	
	public MyString(MyString orig, int begin, int end) {
		this.chars = Arrays.copyOfRange(orig.chars, begin, end);
		length = chars.length;
	}
		
	public char charAt(int index) {
		return chars[index];
	}
	
	public int length() {
		return length;
	}
	
	public MyString substring(int begin, int end) {
		return new MyString(this, begin, end);
	}
	
	public MyString toLowerCase() {
		MyString newString = new MyString(length);
		int i = 0;
		for(char temp : chars) {
			newString.chars[i++] = Character.toLowerCase(temp);
		}
		return newString;
	}
	
	public MyString toUpperCase() {
		MyString newString = new MyString(length);
		int i = 0;
		for(char temp : chars) {
			newString.chars[i++] = Character.toUpperCase(temp);
		}
		return newString;
	}
	
	public MyString getMyString() {
		return this.clone();
	}
	
	public String toString() {
		return new String(chars);// new String(chars.clone()) if String API can't be trusted
	}
	
	public int compareTo(MyString s) { //Should return 
		int i=0,minLength;
		minLength = Integer.min(length, s.length);
		while(i<minLength) {		
			if(chars[i]!=s.chars[i]) {
				return chars[i]-s.chars[i];
			}
			i++;
		}
		return length - s.length;
	}
	
	public boolean equals(MyString s) {
		return Arrays.equals(chars, s.chars);
	}
	
	
	public static MyString valueOf(int i) {

		if(i == 0) {
			char[] zero = {'0'};
			return new MyString(zero);
		}
		
		boolean isNegative = false;
		int index =10;
		int[] ary = new int [index];
		
		if(i < 0) {
			isNegative = true;
			ary[--index] = i%10/-1;
			i /= -10;
		}

		while(i!=0) {
			ary[--index] = i%10;
			i /= 10;
		}
		
		MyString newString;
		
		if(isNegative) {
			newString = new MyString(11-index);
			newString.chars[i++] = '-';
		}
		
		else {
			newString = new MyString(10-index);
		}
		
		while(i<newString.length)
		newString.chars[i++] = (char)(ary[index++] + '0');
		return newString;
	}
	
}


