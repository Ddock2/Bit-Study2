package board;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import board.ui.IBoardUI;

public class BoardUIMapping {
	private HashMap<String, IBoardUI> mapping;
	
	public BoardUIMapping() throws Exception {
		mapping = new HashMap<>();
	
		Properties prop = new Properties();
		InputStream is = new FileInputStream("board_config_properties");
		
		prop.load(is);
		
		String key = "";
		String className = "";
		
		Enumeration<Object> e = prop.keys();
		// 처음부터 순회시킬 때,
		// 원소가 없는지 여부 확인 (Element)
		// 타입입 뭔지 모르니 Object로 받자
		
		while(e.hasMoreElements()) {
			key = (String)e.nextElement();
			// load된 키 값의 전체 
			
			className = (String) prop.get(key);
			// load된 값의 오른쪽을 추출
			
			mapping.put(key, (IBoardUI)(Class.forName(className).newInstance()));
			// newInstance() : 동적으로 객체를 만드는 메소드
			// return type -> Object 이므로,
			// 해당 클래스들을 IBoardUI로 형 변환
		}
	}

	public IBoardUI getBoardUI(String key) {
		return mapping.get(key);
	}
}
