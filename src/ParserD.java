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
        if(index < line.length())token = Character.toString(line.charAt(index));
        index++;
    }
    
    public static void skip(){
        while(token.equals(" ")){
            nextToken();
        }
    }
    
    public static void expect(String t) throws Exception{
        if(token.equals(t)){
            nextToken();
        }else{
            //out.write("Was expected " + t + " instead of "+token+"\n");
            System.out.println("Was expected " + t + " instead of "+token+"\n");
        }
    }
    
    public static void pC() throws Exception{
        pE();
        skip();
        if((token.equals("<") || token.equals(">") || token.equals("=")) && (!token.equals("$"))){
            if(token.equals("<") || token.equals(">") || token.equals("=")){
                nextToken();
                pE();
            }
        }else if(!token.equals("$")){
            //out.write("Was expected < > = instead of "+token+"\n");
            System.out.println("Was expected < > = instead of "+token+"\n");
        }
    }
    
    public static void pE() throws Exception{
        pT();
        skip();
        while((token.equals("+") || token.equals("-")) && (!token.equals("$"))){
            if(token.equals("+") || token.equals("-")){
                nextToken();
                pT();
            }
        }
    }
    
    public static void pT() throws Exception{
        pF();
        skip();
        while((token.equals("*") || token.equals("/")) && (!token.equals("$"))){
            if(token.equals("*") || token.equals("/")){
                nextToken();
                pF();
            }
        }
    }
    
    public static void pF() throws Exception{
        skip();
        if((token.equals("a") || token.equals("b") || token.equals("c")) && (!token.equals("$"))){
            if(token.equals("a") || token.equals("b") || token.equals("c")){
                nextToken();
            }
        }else if(!token.equals("$")){
            //out.write("Was expected a b c ( instead of "+token+"\n");
            System.out.println("Was expected a b c instead of "+token+"\n");
        }
    }
    
    public static void main(String[] args)throws Throwable{
        while(in.ready() || true){
            index = 0;
            line = in.readLine();
            nextToken();
            pC();
            expect("$");
            System.out.println("Expresion correcta\n");
            //out.write("Expresion correcta\n");
        }
        out.close();
    }        
}