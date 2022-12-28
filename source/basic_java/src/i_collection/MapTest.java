package i_collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> param = new HashMap<>();
		param.put("이현무", 50);
		param.put("김근호", 60);
		param.put("이경훈", 15);
		param.put("이운주", 20);

		// R
		int ju = param.get("이운주");
		System.out.println(ju);
		System.out.println(param);
		// D

		param.remove("김근호");
		System.out.println(param);

		Map<String, String> mem = new HashMap<>();
		mem.put("mem_id", "a001");
		mem.put("mem_pw", "asdfasdf");		
	}
}
