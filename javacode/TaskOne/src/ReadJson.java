import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.google.gson.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class ReadJson {
	public void writejson(String str) throws SQLException{
		JsonParser parse=new JsonParser();//创建json解析器
		Mysql mysql=new Mysql();
		try {
			JsonObject json=(JsonObject) parse.parse(str);
			String id=json.get("id").getAsString();//获得id
			
			JsonObject labels=json.get("labels").getAsJsonObject();
			JsonObject en=labels.get("en").getAsJsonObject();
			String labels_en=en.get("value").getAsString();//获得labels_en
			
			String labels_zh=" ";
			if(labels.has("zh")==false){
				labels_zh=" ";
			}else{
				JsonObject zh_cn=labels.get("zh").getAsJsonObject();
				labels_zh=zh_cn.get("value").getAsString();
			}//获得labels_zh

			//System.out.println("labels:"+labels_en+labels_zh);
			
		JsonObject descriptions=json.get("descriptions").getAsJsonObject();
			JsonObject des_en=descriptions.get("en").getAsJsonObject();
			String descriptions_en=des_en.get("value").getAsString();
		//	System.out.println("descriptions:"+descriptions_en);
		
			String descriptions_zh=" ";
			if(descriptions.has("zh")==false){
				descriptions_zh=" ";
			}else{
				JsonObject descriptions_zh_cn=descriptions.get("zh").getAsJsonObject();
				descriptions_zh=descriptions_zh_cn.get("value").getAsString();
				
			}

		//	System.out.println("descriptions:"+descriptions_zh);
		//解析descriptions
			
			JsonObject aliases=json.get("aliases").getAsJsonObject();
			ArrayList<String> ali_list_en=new ArrayList<String>();
			ArrayList<String> ali_list_zh=new ArrayList<String>();
		
			if(aliases.has("en")){
				JsonArray ali_en_arry=aliases.get("en").getAsJsonArray();
				
				for(int j=0;j<ali_en_arry.size();j++){
					JsonObject ali_en= ali_en_arry.get(j).getAsJsonObject();
					ali_list_en.add(ali_en.get("value").getAsString());
				}
			}
			if(aliases.has("zh")){
				JsonArray ali_zh_arry=aliases.get("zh").getAsJsonArray();
				
				for(int j=0;j<ali_zh_arry.size();j++){
					JsonObject ali_zh= ali_zh_arry.get(j).getAsJsonObject();
					ali_list_zh.add(ali_zh.get("value").getAsString());
				}
			}
			String ali_en_str=ali_list_en.toString();
			String ali_zh_str=ali_list_zh.toString();
			
			//System.out.println("ali_list_en:"+ali_list_en+ali_list_zh);
			//解析aliases
		JsonObject claims=json.get("claims").getAsJsonObject();
		String obj=claims.toString();
		ArrayList<String> claimslist=new ArrayList<String>();
		//System.out.println(claims.entrySet());
		 JSONObject object=JSONObject.fromObject(obj);
		 Iterator iterator = object.keys();  
		 String claim="";
            while(iterator.hasNext()){  
            	
              	JSONArray claimsjson = object.getJSONArray((String) iterator.next());
            	for(int ii=0;ii<claimsjson.size();ii++){
            		String vaule="";
            		JSONObject mainsnak=claimsjson.getJSONObject(ii).getJSONObject("mainsnak");
            		String property=mainsnak.getString("property");
            		if(mainsnak.has("datavalue")){
            			JSONObject datavalue=mainsnak.getJSONObject("datavalue");
	            		if(datavalue.has("type")){
	            			if(datavalue.getString("type").equals("string")){
		            			vaule=datavalue.getString("value");
		            		}else if(datavalue.getString("type").equals("wikibase-entityid")){
		            			JSONObject valueobject=datavalue.getJSONObject("value");
		            			String numeric_id=valueobject.getString("numeric-id");
		            			String valueid=valueobject.getString("id");
		            			vaule=numeric_id+","+valueid;
		            		}else if(datavalue.getString("type").equals("time")){
		            			JSONObject valueobject=datavalue.getJSONObject("value");
		            			String time=valueobject.getString("time");
		            			String calendarmodel=valueobject.getString("calendarmodel");
		            			vaule=time+","+calendarmodel;
		            		}else if(datavalue.getString("type").equals("monolingualtext")){
		            			JSONObject valueobject=datavalue.getJSONObject("value");
		            			String text=valueobject.getString("text");
		            			String language=valueobject.getString("language");
		            			vaule=text+","+language;
		            		}
		            		else if(datavalue.getString("type").equals("quantity")){
		            			JSONObject valueobject=datavalue.getJSONObject("value");
		            			String amount=valueobject.getString("amount");
		        
		            			vaule=amount;
		            		}
		            		else if(datavalue.getString("type").equals("globecoordinate")){
		            			JSONObject valueobject=datavalue.getJSONObject("value");
		            			String latitude=valueobject.getString("latitude");
		            			String longitude=valueobject.getString("longitude");
		            			String globe=valueobject.getString("globe");				            			
		            			vaule=latitude+","+longitude+","+longitude;
		            		}
		            		else{
		            			vaule="没有";
		            		}
	            		}
            		}       		
            			
            		
            	
            		claim=property+":"+vaule+"##"+claim;
            		
            		//System.out.println(property);
            	}       
            }  
           
            System.out.println(claim);
           
          //  System.out.println( claimslist);
           /* System.out.println(id+"\n"+labels_zh+"\n"+labels_en+"\n"
            					+descriptions_en+"\n"+descriptions_zh+"\n"
            					+ali_en_str+"\n"+ali_zh_str+"\n");
            					*/
		
	        //存ID
			if(id.substring(0, 1).equals("Q")||id.substring(0,1).equals("q")){
				mysql.insertSQLNum("tb_fristnum_q", id, labels_en);
			}else{
				mysql.insertSQLNum("tb_fristnum_p", id, labels_en);
			}
			//存Word
	          String fristNum=(String) labels_en.subSequence(0, 1);
			
				if(fristNum.equals("K")||fristNum.equals("k")||
						fristNum.equals("V")||fristNum.equals("v")){
					
					mysql.insertWord("tb_word_kv", labels_en, id, labels_zh, 
							descriptions_en, descriptions_zh,
							ali_en_str,ali_zh_str, claim);
				}else if(fristNum.equals("B")||fristNum.equals("b")||fristNum.equals("C")||
						fristNum.equals("c")||fristNum.equals("F")||fristNum.equals("f")||
						fristNum.equals("G")||fristNum.equals("g")||fristNum.equals("M")||
						fristNum.equals("m")||fristNum.equals("P")||fristNum.equals("p")||
						fristNum.equals("U")||fristNum.equals("u")||fristNum.equals("W")||
						fristNum.equals("w")||fristNum.equals("Y")||fristNum.equals("y")||
						fristNum.equals("D")||fristNum.equals("d")||fristNum.equals("l")||
						fristNum.equals("L")){
					mysql.insertWord("tb_word_"+fristNum.toLowerCase(), labels_en, id, labels_zh, 
							descriptions_en, descriptions_zh,
							ali_en_str,ali_zh_str, claim);
					
				}else if(fristNum.equals("E")||fristNum.equals("e")){
					  String sendNum=(String) labels_en.subSequence(1, 2);
					  String pattern1 = "[a-gA-G]";
					  String pattern2 = "[h-pH-P]";
					  if(Pattern.matches(pattern1, sendNum)){
						  mysql.insertWord("tb_word_e_0", labels_en, id, labels_zh, 
									descriptions_en, descriptions_zh,
									ali_en_str,ali_zh_str, claim);
					  }else if(Pattern.matches(pattern2, sendNum)){
						  mysql.insertWord("tb_word_e_1", labels_en, id, labels_zh, 
									descriptions_en, descriptions_zh,
									ali_en_str,ali_zh_str, claim);
					  }else{
						  mysql.insertWord("tb_word_e_2", labels_en, id, labels_zh, 
									descriptions_en, descriptions_zh,
									ali_en_str,ali_zh_str, claim);
					  }
				     
				}else if(fristNum.equals("A")||fristNum.equals("a")||fristNum.equals("H")||fristNum.equals("h")
						||fristNum.equals("i")||fristNum.equals("I")||fristNum.equals("n")
						||fristNum.equals("N")||fristNum.equals("o")||fristNum.equals("O")
						||fristNum.equals("R")||fristNum.equals("r")||fristNum.equals("S")
						||fristNum.equals("s")||fristNum.equals("T")||fristNum.equals("t")){
					 String sendNum=(String) labels_en.subSequence(1, 2);
					  String pattern1 = "[a-jA-J]";
					  if(Pattern.matches(pattern1, sendNum)){
						  mysql.insertWord("tb_word_"+fristNum.toLowerCase()+"_0", labels_en, id, labels_zh, 
									descriptions_en, descriptions_zh,
									ali_en_str,ali_zh_str, claim);
					  }else {
						  mysql.insertWord("tb_word_"+fristNum.toLowerCase()+"_1", labels_en, id, labels_zh, 
									descriptions_en, descriptions_zh,
									ali_en_str,ali_zh_str, claim);
					  }
									
				
				}else{
				mysql.insertWord("tb_word_jqxz", labels_en, id, labels_zh, 
						descriptions_en, descriptions_zh,
						ali_en_str,ali_zh_str, claim);
				}
					
				mysql.closeDB();
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			//String str=str("");
			//ReadJson r=new ReadJson();
			//r.writejson();
		}
}

