import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class TestCompiler {
    public static void main(String[] args) throws
            Exception{

        System.out.print("Enter java file path: ");
        Scanner sc =new Scanner(System.in);
        String fileName= sc.nextLine();
        //open file
        File file =new File(fileName);
        FileInputStream fis=null;
        //open the input file stream
        fis=new FileInputStream(file);
        ANTLRInputStream input =new ANTLRInputStream(fis);
        StatementsLexer lexer=new StatementsLexer(input);
        CommonTokenStream tokens =new CommonTokenStream(lexer);
        StatementsParser parser =new StatementsParser(tokens);//token is name for lexem
        ParseTree tree = parser.prog();
        TokenStreamRewriter rewriter=new TokenStreamRewriter(tokens);
        MyStatementsListener myStatementsListener =new MyStatementsListener(rewriter);

        ParseTreeWalker walker =new ParseTreeWalker();
        MyStatementsListener myStatementsListener1= new MyStatementsListener(rewriter);
        walker.walk(myStatementsListener1,tree);//walk on tree using functions exist in function"list base listner"{enter liost base listner}{and exist from that element}
        //System.out.println(myStatementsListener1);
        File output = new File("output.txt");
        output.createNewFile();
        FileWriter w = new FileWriter("output.txt");
        w.write(myStatementsListener1.rewriter.getText());
        w.close();

        System.out.println("start sceuss");
    }}
