package map;

import java.util.HashMap;
import java.util.Map;

public class MapDame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map =new HashMap<String, Integer>();
		/**
		 * T put(K k,V v)
		 * 将给定的key与对应的value存入Map中
		 * 若给定的key在map中不存在，则添加新内容
		 * 返回值为null
		 * 如果给定的key存在，则替换value操作
		 * 返回被替换的值
		 */
		map.put("语文", 90);
		map.put("数学", 35);
		map.put("英语", 54);
		map.put("化学", 78);
		map.put("体验", 98);
		map.put("政治", 65);
		/**
		 * V get(K k)
		 * 根据给定的key获取对应的value
		 */
		Integer num=map.get("语文");
		System.out.println(num);
		/**
		 * V remove(K k)
		 * 根据给定的key删除这一项
		 * 并返回
		 */
		
	}

}
