import java.io.*;
import java.util.HashSet;

/**
 * @author KevinMendieta
 */
public class ParserD{

    /* BNF used:
     *C ::= E [(>|<|=)E]
     *E ::= T{(+ | −)T}
     *T ::= F{(∗ | ÷)F}
     *F ::= a | b | c | (E)
     */

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String token, line;
    public static int index;
    public static boolean isCorrect;
    public static HashSet<String> set;

    /*
     *Fills the set with the correct characters.
     */
    public static void fillSet(){
        set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("(");
        set.add(")");
        set.add("/");
        set.add("*");
        set.add("+");
        set.add("-");
        set.add("=");
        set.add("<");
        set.add(">");
        set.add("$");
        set.add(" ");
    }

    /*
     *Moves token through the line.
     */
    public static void nextToken() throws Exception{
        if(index < line.length()){
            token = Character.toString(line.charAt(index));
            index++;
            if(!set.contains(token)){
                isCorrect = false;
                //System.out.println("Error: columna " + index + ", " + token + " caracter inesperado.\n");
                out.write("Error: columna " + index + ", " + token + " caracter inesperado.\n");
            }            
        }
    }

    /*
     *Skips all the whites spaces until a non white space character apperas.
     */
    public static void skip() throws Exception{
        while(token.equals(" ")){
            nextToken();
        }
    }

    /*
     *Compares the token with a given character t.
     */
    public static void expect(String t) throws Exception{
        if(token.equals(t)){
            nextToken();
        }else if (isCorrect){
            //System.out.println("Error: columna " + index + " , " + "se esperaba: " + t + "en vez de: " + token);
            if (t.equals("$")){
                out.write("Error: columna " + index + " , fin de entrada inesperado.\n");
            }else{
                out.write("Error: columna " + index + " , se esperaba: " + t + "en vez de: " + token + "\n");
            }
            isCorrect = false;
        }
    }

    /*
     *C ::= E [(>|<|=)E]
     */
    public static void pC() throws Exception{
        pE();
        skip();
        if((token.equals("<") || token.equals(">") || token.equals("=")) && (!token.equals("$") && isCorrect)){
            nextToken();
            pE();
        }else if(!token.equals("$") && isCorrect){
            out.write("Error: columna " + index + ", " + token + " caracter inesperado.\n");
            //System.out.println("Was expected < > = instead of "+token+"\n");
            isCorrect = false;
        }
    }

    /*
     *E ::= T{(+ | −)T}
     */
    public static void pE() throws Exception{
        pT();
        skip();
        while((token.equals("+") || token.equals("-")) && (!token.equals("$") && isCorrect)){
            nextToken();
            pT();
            skip();
        }
    }

    /*
     *T ::= F{(∗ | ÷)F}
     */
    public static void pT() throws Exception{
        pF();
        skip();
        while((token.equals("*") || token.equals("/")) && (!token.equals("$") && isCorrect)){
            nextToken();
            pF();
            skip();
        }
    }

    /*
     *F ::= a | b | c | (E)
     */
    public static void pF() throws Exception{
        skip();
        if((token.equals("a") || token.equals("b") || token.equals("c") || token.equals("(")) &&  isCorrect){
            if(token.equals("(")){
                nextToken();pE();expect(")");
            }else{
                nextToken();
            }
            
        }else if(isCorrect){
            out.write("Error: columna " + index + ", " + token + " caracter inesperado.\n");
            //System.out.println("Was expected a b c instead of "+token+"\n");
            isCorrect = false;
        }
    }

    public static void main(String[] args)throws Throwable{
        while(in.ready()){
            fillSet();
            index = 0;
            isCorrect = true;
            line = in.readLine();
            nextToken();
            pC();
            expect("$");
            if (isCorrect) out.write("Expresion correcta\n");
            //if (isCorrect) System.out.println("Expresion correcta\n");
        }
        out.close();
    }

}
