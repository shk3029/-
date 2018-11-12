package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 효율성 실패 
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Hash_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); 
		System.out.println("start");		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String result = solution2(participant, completion);
		System.out.println(result);
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start ));
	}

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> solutionMap = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
        	solutionMap.put(participant[i], solutionMap.getOrDefault(participant[i],0) + 1);  
        }
        for(int i=0; i<completion.length; i++) {
        	solutionMap.put(completion[i], solutionMap.get(completion[i])-1);  
        }
             
        Iterator<String> iterator = solutionMap.keySet().iterator();
        while(iterator.hasNext()) {
        	String key = (String) iterator.next();

        	if(solutionMap.get(key) != 0) {
        		answer = answer + key;
        	}
        }
      
        return answer;
/*		
 * 		테스트케이스 성공 / 효율성 실패 
 *      HashMap<String, Boolean> solutionMap = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
         boolean flag = false;
         for(int j=0; j<completion.length; j++) {
          if(participant[i].equals(completion[j])) {
           flag = true;
           completion[j] = "";
           break;
          } 
         }
         solutionMap.put(participant[i], flag);  
        }
        
        
        Iterator<String> iterator = solutionMap.keySet().iterator();
        while(iterator.hasNext()) {
         String key = (String) iterator.next();
         if(!solutionMap.get(key)) {
          answer = answer + key;
         }
        }
      
        return answer;
 */
    }
    // 영우
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>();

        for(String person : participant) {
            hashMap.put(person, hashMap.getOrDefault(person, 0)+1);
        }

        for(String person : completion) {
            hashMap.put(person, hashMap.get(person) -1);
        }

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) !=  0) {
                answer = key;
            }
        }

        return answer;
    }

}
