import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.FileReader;  
import java.lang.reflect.Type;
import java.security.KeyStore.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.util.regex.*;

public class WriteJsonNum {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		JsonParser parse=new JsonParser();//创建json解析器
	//	Mysql mysql=new Mysql();
		try {
			JsonArray jsonArry=(JsonArray) parse.parse(new FileReader("./text.json"));
			for(int i=0;i<jsonArry.size();i++){
				System.out.println(i);
				JsonObject json=jsonArry.get(i).getAsJsonObject();
				String id=json.get("id").getAsString();//获得id
				//System.out.println(id);
					JsonObject labels=json.get("labels").getAsJsonObject();
					JsonObject en=labels.get("en").getAsJsonObject();
					String labels_en=en.get("value").getAsString();//获得labels_en
			
					String labels_zh="";
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
		
					String descriptions_zh="";
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

					//System.out.println("ali_list_en:"+ali_list_en+ali_list_zh);
					//解析aliases
				JsonObject claims=json.get("claims").getAsJsonObject();
				
				
				String obj=claims.toString();
				ArrayList<String> claimslist=new ArrayList<String>();
				//System.out.println(claims.entrySet());
				 JSONObject object=JSONObject.fromObject(obj);
				 Iterator iterator = object.keys();  
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
		            			
		            		
		            	
		            		
		            		System.out.println(property+"===>"+vaule);
		            		//System.out.println(property);
		            	}
		            		
		            	
		                        
		            }  
		            String claim=claimslist.toString();
		       
		          //  System.out.println( claimslist);
		        //存ID
		
						
						
			}
		
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
