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
		 * ��������key���Ӧ��value����Map��
		 * ��������key��map�в����ڣ������������
		 * ����ֵΪnull
		 * ���������key���ڣ����滻value����
		 * ���ر��滻��ֵ
		 */
		map.put("����", 90);
		map.put("��ѧ", 35);
		map.put("Ӣ��", 54);
		map.put("��ѧ", 78);
		map.put("����", 98);
		map.put("����", 65);
		/**
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��value
		 */
		Integer num=map.get("����");
		System.out.println(num);
		/**
		 * V remove(K k)
		 * ���ݸ�����keyɾ����һ��
		 * ������
		 */
		
	}

}
