import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
public class MyStatementsListener extends JavaParserBaseListener {
    int c = 0;

    // String x = 1;
    TokenStreamRewriter rewriter;
    TokenStreamRewriter rewriter2;

    TokenStreamRewriter rewriter3;
    // w1.write(myStatementsListener1.rewriter.getText());
    String data = "This is the data in the output file";


    // Creates a Writer using FileWriter
    Writer output;

    {
        try {
            output = new FileWriter("output5.java");
            output.write(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int y = 0;

    MyStatementsListener(TokenStreamRewriter rewriter, int x) {
        if (x == 1) {
            y = 1;
            this.rewriter = rewriter;
        } else if (x == 2) {
            y = 2;
            this.rewriter2 = rewriter;
        }


        // this.rewriter = rewriter;

    }
    
@Override
    public void enterClassBody(JavaParser.ClassBodyContext ctx) {

        if(y==1){

            this.rewriter.insertAfter(ctx.getStart(),

                    "        static FileWriter w;\n" +
                            "    static FileWriter wcss;\n" +
                            "   static int c=1;"
            );



        }}
    
}
