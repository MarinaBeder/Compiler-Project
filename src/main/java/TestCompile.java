import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class TestCompile {
    static FileWriter output1;
    static FileWriter wcss;


    public static void main(String[] args) throws
            Exception{


        /*String URL ="htmloutput.html";
            File file22 =new File(URL);
            try {
                Desktop.getDesktop().browse(file22.toURI());
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }*/

        System.out.print("Enter java file path: ");
        Scanner sc =new Scanner(System.in);
        String fileName= sc.nextLine();
        //open file
        File file =new File(fileName);
        FileInputStream fis=null;
        //open the input file stream
        fis=new FileInputStream(file);
        ANTLRInputStream input =new ANTLRInputStream(fis);


        JavaLexer lexer=new JavaLexer(input);
        CommonTokenStream tokens =new CommonTokenStream(lexer);
        JavaParser parser =new JavaParser(tokens);//token is name for lexem
        ParseTree tree = parser.block();


        JavaParserBaseListener myStatementsListener =new JavaParserBaseListener();

        ParseTreeWalker walker =new ParseTreeWalker();





        //open the input file stream



        TokenStreamRewriter rewriter=new TokenStreamRewriter(tokens);
        TokenStreamRewriter rewriter2=new TokenStreamRewriter(tokens);



        MyStatementsListener myStatementsListener1= new MyStatementsListener(rewriter,1);
        walker.walk(myStatementsListener1,tree);//walk on tree using functions exist in function"list base listner"{enter liost base listner}{and exist from that element}
        MyStatementsListener myStatementsListener2= new MyStatementsListener(rewriter2,2);

        walker.walk(myStatementsListener2,tree);//walk on tree using functions exist in function"list base listner"{enter liost base listner}{and exist from that element}


        File outputListener = new File("output.java");
        outputListener.createNewFile();
        FileWriter w1 = new FileWriter("output.java");
        w1.write(myStatementsListener1.rewriter.getText());
        w1.close();

        try{
            File outputListener2 = new File("test.html");
            outputListener.createNewFile();
            FileWriter w2 = new FileWriter("test.html");
            w2.write(myStatementsListener2.rewriter2.getText());
            w2.close();}
        catch(IOException e){}



    }



}
