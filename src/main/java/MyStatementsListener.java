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
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        if(y==2){
            this.rewriter2.insertBefore(ctx.getStart(),"<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "\"<body style=\"background-color:green;\">\n"+
                    "<link href=\"wcss.css\" rel=\"stylesheet\" type=\"text/css\">\n"+
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<pre>");
            this.rewriter2.insertAfter(ctx.getStop(),"</pre>\n" +
                    "</html>");
        }
        if(y==1){
            this.rewriter.insertBefore(ctx.getStart(),
                    "import java.io.*;\n" +
                            "import java.io.File;\n" +
                            "import java.io.FileInputStream;\n" +
                            "import java.io.FileWriter;\n" +
                            "import java.io.IOException;\n" +
                            "import java.util.Scanner;\n");
        }}
    
}
