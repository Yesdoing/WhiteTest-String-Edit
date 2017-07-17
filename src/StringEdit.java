import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringEdit {
	
	public static void main(String[] args) {
		System.out.println("문자열을 입력하세요!!");
		inputString();
	}
	
	private static void inputString() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		invertStr(str);
		alphaNum(str);
		eachAlphaNum(str);
	}
	
	private static void invertStr(String str) {
		if(str.contains("?")) {
			String[] arrStr = splitStr(str);
			for(int i=arrStr.length-1; i>0; i--) {
				System.out.print(arrStr[i] + " ");
			}
			System.out.println(arrStr[0] + "?");
		}
		else {
			String[] arrStr = str.split(" ");
			for(int i=arrStr.length-1; i>0; i--) {
				System.out.print(arrStr[i] + " ");
			}
			System.out.println(arrStr[0]);
		}
	}
	
	private static void alphaNum(String str) {
		if(str.contains("?")){
			String[] arrStr = splitStr(str);
			int strNum = 0;
			for(int i=0; i<arrStr.length; i++){
				strNum += arrStr[i].length();
			}
			
			System.out.println("전체 수 : " + strNum);
		} else {
			String[] arrStr = str.split(" ");
			int strNum = 0;
			for(int i=0; i<arrStr.length; i++){
				strNum += arrStr[i].length();
			}
			
			System.out.println("전체 수 : " + strNum);
		}
	}
	
	private static String[] splitStr(String str) {
		int markIndex = str.indexOf("?");
		String nonMarkStr = str.substring(0, markIndex);
		String[] arrStr = nonMarkStr.split(" ");
		return arrStr;
	}
	
	private static void eachAlphaNum(String str) {
		int markIndex = str.indexOf("?");
		String nonMarkStr = str.substring(0, markIndex);
		nonMarkStr = nonMarkStr.replaceAll(" ", "");
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<nonMarkStr.length(); i++) {
			if(!map.containsKey(nonMarkStr.charAt(i))) {
				map.put(nonMarkStr.charAt(i), 1);
			} else {
				map.put(nonMarkStr.charAt(i), map.get(nonMarkStr.charAt(i))+1);
			}
		}
		
		Iterator it =  sortByValue(map).iterator();
		
		while(it.hasNext()) {
			char temp = (char) it.next();
			System.out.println(temp + " = " + map.get(temp));
		}
	}
	
	private static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				
				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;
	}
}