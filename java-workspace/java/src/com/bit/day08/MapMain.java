package com.bit.day08;

import java.util.Hashtable;
import java.util.Map;

/*
	Map 주요 메소드			K : Key 타입, V : Value 타입
	- V put(K key, V value)		: 데이터 입력
	- V get(K key)				: 특정 key에 대한 value 추출
	- V remove(Object key)		: 특정 key에 대한 Map요소 삭제
	
 */

public class MapMain {
	
	public static void main(String[] args) {
		/*
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "a123");
		map.put("bbb", "b456");
		map.put("ccc", "c789");
		
		// key의 중복은 허용하지 않는다
		map.put("ccc", "a123");	// 동일 키에 대한 입력은 업데이트, value 중복 가능
		System.out.println("aaa key에 대한 value : " + map.get("aaa"));
		System.out.println("bbb key에 대한 value : " + map.get("bbb"));
		System.out.println("ccc key에 대한 value : " + map.get("ccc"));
		
		System.out.println("============================================");
		
		// 비밀번호 변경
		Scanner s = new Scanner(System.in);
		System.out.print("ID 입력 : ");
		String id = s.nextLine();
		
		// key
		if(map.containsKey(id)) {
			System.out.println("ID : [" + id + "]");
		} else {
			System.out.println("해당 ID는 존재하지 않습니다.");
			System.out.println("[System] : 프로그램 종료");
			System.exit(0);		// 프로그램 종료
		}
		
		// value
		System.out.print("현재 PASSWORD 입력 : ");
		String pw = s.nextLine();
		
		if(map.get(id).equals(pw)) {
			System.out.println("[System] : 일치합니다.");
			System.out.print("변경할 PASSWORD 입력 : ");
			String newPw = s.nextLine();
			map.put(id, newPw);	// update
		}else {
			System.out.println("비밀번호가 일치하지 않습니다");
			System.out.println("[System] : 프로그램 종료");
			System.exit(0);		// 프로그램 종료
		}
		System.out.println("비밀번호가 변경되었습니다.");
		
		// keySet() : map요소의 key들을 Set으로 반환
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(key + " " + map.get(key));
		}
		
		// entrySet()
		Set<Entry<String, String>> entry = map.entrySet();
		for(Entry<String, String> e : entry) {
			System.out.println("ID : " + e.getKey()
								+ ", PW : " + e.getValue());
		}
		
		s.close();
		*/
		
		// HashTable
//		Map<String, Integer> map = new Hashtable<String, Integer>();
//		map.put("one", new Integer(1));	// Boxing
//		map.put("two", 2);				// Auto Boxing
//		map.put("three", 3);
//		
//		Integer iVal = map.get("two");
//		System.out.println(iVal);
		
		// 제공하는 메소드의 동기화 여부
		Map<String, String> map = new Hashtable<String, String>();	// null을 허용하지 않음, 동기화 되어있음
//		Map<String, String> map = new HashMap<String, String>();	// null을 허용한다, 동기화가 되지않음 -> 자원공유의 문제점, 멀티 쓰레드 환경에서 조심
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", null);
		
		String str = map.get("three");
		System.out.println(str);
	}
	
}
