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
    
    public static void expect(String t) throws Exception{
        if(token.equals(t)){
            nextToken();
        }else{
            out.write("Was expected " + t + " instead of "+token+"\n");
        }
    }
    
    public static void pC() throws Exception{
        pE();
        if(token.equals("<") || token.equals(">") || token.equals("=") || token.equals(" ")){
            if(token.equals("<") || token.equals(">") || token.equals("=")){
                nextToken();
                pE();
            }else{
                while(!token.equals(" ")){
                    nextToken();
                }
            }       
        }else{
            out.write("Was expected < > = instead of "+token+"\n");
        }
    }
    
    public static void pE() throws Exception{
        pT();
        while(token.equals("+") || token.equals("-") || token.equals(" ")){
            if(token.equals("+") || token.equals("-")){
                nextToken();
                pT();
            }else if(token.equals(" ")){
                nextToken();
            }         
        }
    }
    
    public static void pT() throws Exception{
        pF();
        while(token.equals("*") || token.equals("/") || token.equals(" ")){
            if(token.equals("*") || token.equals("/")){
                nextToken();
                pF();
            }else if(token.equals(" ")){
                nextToken();
            }
        }
    }
    
    public static void pF() throws Exception{
        System.out.println("el token: "+token);
        if(token.equals("a") || token.equals("b") || token.equals("c") || token.equals(" ")){
            if(token.equals("a") || token.equals("b") || token.equals("c")){
                nextToken();
            }else{
                while(!token.equals(" ")){
                    nextToken();
                }
            }
        }else if(token.equals("(")){
            if(token.equals("(")){
                nextToken();
                pE();
                expect("");
            }
        }else{
            out.write("Was expected a b c ( instead of "+token+"\n");
        }
    }
    
    public static void main(String[] args)throws Throwable{
        while(!in.ready() || true){
            index = 0;
            line = in.readLine();
            nextToken();
            System.out.println("letra "+line.substring(0, 1));
            pC();
            expect("$");
            out.write("Succes "+line+"\n");
            break;
        }
        out.close();
    }        
}