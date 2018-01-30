import java.util.regex.*;

public class RegexText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String content = "za";
			 
			      String pattern = "[a-gA-G]";
			 
			      boolean isMatch = Pattern.matches(pattern, content);
			      System.out.println(isMatch);
	}

}
