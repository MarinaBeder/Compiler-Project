import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;


public class TestCompile {
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


        JavaLexer lexer=new JavaLexer(input);
        CommonTokenStream tokens =new CommonTokenStream(lexer);
        JavaParser parser =new JavaParser(tokens);//token is name for lexem
        ParseTree tree = parser.block();
        TokenStreamRewriter rewriter=new TokenStreamRewriter(tokens);
        JavaParserBaseListener myStatementsListener =new JavaParserBaseListener();

        ParseTreeWalker walker =new ParseTreeWalker();

        MyStatementsListener myStatementsListener1= new MyStatementsListener(rewriter);
        walker.walk(myStatementsListener1,tree);//walk on tree using functions exist in function"list base listner"{enter liost base listner}{and exist from that element}


        MyStatementsVisitor myStatementsVisitor= new MyStatementsVisitor(rewriter);
        myStatementsVisitor.visit(tree);
        //myStatementsListener.visit(tree);
         File outputListener = new File("outputListener.java");
        outputListener.createNewFile();
        FileWriter w1 = new FileWriter("outputListener.java");
        w1.write(myStatementsListener1.rewriter.getText());
        w1.close();
        ///////////////////////////////////////////////////////////////////////////////
        myStatementsVisitor.fileVisited();

        }
        }
