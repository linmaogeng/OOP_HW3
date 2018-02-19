import java.util.*;

public class MyStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j=-50000,begin=0 ,end=0,size = 65536,stage = 0;
		MyString target,dump;
		String st1,st2,error[] = new String[10];
		char[] charArray = new char[size],duplicate = new char[size];
		Random charCode = new Random();

		for(i=0;i<65536;i++) {
			charArray[i]= (char) i;
			duplicate[i] = (char) charCode.nextInt(size);
		}
		error[0]= "test stage 1 begins";
		while(j!=size){
			begin = charCode.nextInt(size);
			end = charCode.nextInt(size);
			
			if(begin>=end) {
				i = begin;
				begin = end;
				end = ++i;
			}
			
			target = new MyString(Arrays.copyOfRange(charArray, begin, end));
			dump = new MyString(Arrays.copyOfRange(duplicate, begin, end));
			st1 = new String(Arrays.copyOfRange(charArray, begin, end));
			st2 = new String(Arrays.copyOfRange(duplicate, begin, end));
			begin = st1.compareTo(st2);
			end = target.compareTo(dump);
			i = target.compareTo(dump);
			System.out.println(i);
			System.out.println(begin);
			System.out.println(end);
			
			if(i == 0) {
				error[stage++] ="Stage " + stage + " passed";
				System.out.println("last run");
				System.out.println(target);
				System.out.println(dump);
				System.out.println(st1);
				System.out.println(st2);
				break;
			}
			
			if(st1.compareTo(st2) == 0) {
				error[stage] ="Stage " + stage + " goes wrong!!!";
				System.out.println("last run");
				System.out.println(target);
				System.out.println(dump);
				System.out.println(st1);
				System.out.println(st2);
				System.out.println(error[stage++]);
				break;
			}
			
			dump = target;
			if(dump != target) {
				error[stage++] = "get reference failed";
				break;
			}		
			
			dump = target.getMyString();
			if(dump == target) {
				error[stage++] = "getMyString failed";
				break;
			}

			
			else if(!dump.equals(target)) {
				error[stage++] = "equals to failed";
				break;
			}
			
			else if(dump.compareTo(target) != 0) {
				error[stage++] = "compareTo failed";
				break;
			}

			else if(dump.length() != target.length()) {
				error[stage++] = "wrong length";
				break;
			}
			
			dump = target.substring(0, target.length());
			
			if(target == dump) {
				error[stage++] = "substring goes wrong";
				break;
			}
			
			else if(dump == target.substring(0, target.length())) {
				error[stage++] = "substring goes wrong";
				break;
			}
			
			else if(!MyString.valueOf(j).toString().equals(String.valueOf(j))) {
				error[stage++] = "valueOf goes wrong";
				break;
			}
			
			j++;
		}
		System.out.printf("Stage #1 stopped with loop index %2d \n", j);
		error[stage++] = "test #1 passed";
		
		
		
		for(String str: error) {
			if(str != null) {
				System.out.println(str);
				MyString newstr = new MyString(str.toCharArray());
				System.out.println(newstr);
				
				
				str = str.toUpperCase();
				newstr = newstr.toUpperCase();
				if(!str.equals(newstr.toString())){
					error[stage++] = "toUpperCase failed";
				}
				
				else {
					System.out.println("toUpperCase passed");
				}
				
				System.out.println(str);
				System.out.println(newstr);
				
				str = str.toLowerCase();
				newstr = newstr.toLowerCase();
				
				if(!str.equals(newstr.toString())){
					error[stage++] = "toLowerCase failed";
				}
				
				else {
					System.out.println("toLowerCase passed");
				}

				System.out.println(str);
				System.out.println(newstr);
				
				for(int index = 0; index < str.length(); index++) {
					if(str.charAt(index)!=newstr.charAt(index)) {
						error[stage++] = "charAt failed";
					}
					
					else {
						System.out.println("charAt passed");
					}
				}			
				
			}
			
		}	
		
	}

}
