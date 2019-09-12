import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigInteger;

public class AnagramTester {
	
	/*
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> lineStrings = new ArrayList<String>();
		
		while (sc.hasNextLine()){
			String line = sc.nextLine();
			if (line.isEmpty()){
				break;
			}
			lineStrings.add(line);
		}
		
		for (int i = 0; i < lineStrings.size(); i++){
			FindPermutations(lineStrings.get(i));
		}
		
		sc.close();
	}
	*/
	
	public static void FindPermutations(String input){
		
        char[] chars = input.toCharArray();

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        //Fills the hashmap with the amount of each distinct char
        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];
            
            if (charCountMap.containsKey(x)){
                int count = charCountMap.get(x);
                count++;
                charCountMap.put(x, count);
            } else {
            	charCountMap.put(x, 1);
            }
        }
        
        //Finds the permutations of the charArray by calculating the factorial of its length
        //and then handles duplicates by dividing the result by the factorials of every count of each char
        BigInteger result = Factorial(chars.length);
        
        for (int count : charCountMap.values()){
        	BigInteger factorialCount = Factorial(count);
            result = result.divide(factorialCount); 
        }

        System.out.println(result);
    }
    
    public static BigInteger Factorial(int num){
        if(num == 0)
            return BigInteger.ONE;
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
}
