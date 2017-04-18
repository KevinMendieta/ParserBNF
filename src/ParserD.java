import java.io.*;

/**
 * @author KevinMendieta
 */
public class ParserD {
    
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String token, line;
    public static int index;
    
    public static void nextToken(){
        token = line.substring(index, index);
        index++;
    }
    
    public static void expect(String t){
        if(token.equals(t)){
            nextToken();
        }else{
            //Throw new Exception();
        }
    }
    
    public static void main(String[] args)throws Throwable{
        while(in.ready()){
            index = 0;
            String line = in.readLine();
            nextToken();
            
        }
    }        
}