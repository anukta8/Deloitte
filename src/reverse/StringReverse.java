package reverse;

public class StringReverse {
	public static void main(String[] args)
	{
		
				String inp = "Mynameisswetha";
				inp = rev(inp);
				int noOfVowels=0;
				for(int i=0;i<inp.length();i++) {
					if(inp.charAt(i)=='a'||inp.charAt(i)=='e'||inp.charAt(i)=='i'||inp.charAt(i)=='o'||inp.charAt(i)=='u') {
						noOfVowels++;
					}
				}
				System.out.println("The String after reversed is: "+inp);
				System.out.println("The number  of Vowels in the string are: "+noOfVowels);
			}
			
			public static String rev(String inp ) {
				String ans="";
				
				for(int i=inp.length()-1;i>=0;i-- ) {
					ans+=inp.charAt(i);
				}
				return ans;
			}

		}
	
		
	


