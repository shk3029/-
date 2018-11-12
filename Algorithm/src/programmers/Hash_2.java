package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  https://programmers.co.kr/learn/courses/30/lessons/42577
 *  합격 (테스트 o 효율성 o)
 */ 
public class Hash_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");		
		String[] phone_book = {"97674223", "1195524421","112", "99", "97"};
		boolean result = solution2(phone_book);
		System.out.println(result);
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;

        List<String> list = new ArrayList<>();
        
        for(int i=0; i<phone_book.length; i++) {
        	if(i==0) {
        		list.add(phone_book[0]);
        	} else {
        		for(int j=0; j<list.size(); j++) {
        			if(phone_book[i].length() <= list.get(j).length()) {
                 		if(list.get(j).contains(phone_book[i]) && list.get(j).indexOf(phone_book[i]) == 0 && !list.get(j).equals(phone_book[i]) ) {
                 			answer = false;
                 		}
                 	} else {
                 		if(phone_book[i].contains(list.get(j)) && phone_book[i].indexOf(list.get(j)) == 0 && !list.get(j).equals(phone_book[i])) {
                 			answer = false;
                 		}
                 	}      			
        		}
        	}
        }
        return answer;
    }
    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i< phone_book.length-1; i++) {
            int current = phone_book[i].length();
            int next = phone_book[i+1].length();

            if(current < next) {
                if(phone_book[i+1].contains(phone_book[i])) {
                    answer =false;
                    break;
                }
            }
        }
        return answer;
    }
}
