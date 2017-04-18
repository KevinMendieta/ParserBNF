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
    
    public static void expect(String t) throws Exception{
        if(token.equals(t)){
            nextToken();
        }else{
            throw new Exception("Was expected" + t + "instead of "+token);
            //out.write("Was expected" + t + "instead of "+token+"\n");
        }
    }
    
    public static void pC() throws Exception{
        pE();
        if(token.equals("<") || token.equals(">") || token.equals("=") || token.equals(" ")){
            if(token.equals("<") || token.equals(">")){
                nextToken();
                pE();
            }            
        }else{
            throw new Exception("Was expected < > = instead of "+token);
            //out.write("Was expected < > = instead of "+token+"\n");
        }
    }
    
    public static void pE() throws Exception{
        pT();
        while(token.equals("+") || token.equals("-") || token.equals(" ")){
            if(token.equals("+") || token.equals("-")){
                nextToken();
                pT();
            }            
        }
    }
    
    public static void pT() throws Exception{
        pF();
        while(token.equals("*") || token.equals("/") || token.equals(" ")){
            if(token.equals("*") || token.equals("/")){
                nextToken();
                pF();
            }            
        }
    }
    
    public static void pF() throws Exception{
        if(token.equals("a") || token.equals("b") || token.equals("c") || token.equals(" ")){
            if(token.equals("a") || token.equals("b") || token.equals("c")){
                nextToken();
            }
        }else if(token.equals("(") || token.equals(" ")){
            if(token.equals("(")){
                nextToken();
                pE();
                expect("");
            }
        }else{
            throw new Exception("Was expected a b c ( instead of "+token);
            //out.write("Was expected a b c ( instead of "+token+"\n");
        }
    }
    
    public static void main(String[] args)throws Throwable{
        while(in.ready()){
            index = 0;
            line = in.readLine();
            nextToken();
            pC();
            expect("$");
            out.write("Succes "+line+"\n");
        }
        out.close();
    }        
}