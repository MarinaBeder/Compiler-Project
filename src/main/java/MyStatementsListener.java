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

 int par=1;
    @Override
    public void enterParExpression(JavaParser.ParExpressionContext ctx) {
        if(y==2){
            int x=1;

            if(ctx.getText().startsWith("(")) {
                
                par=par+1;
                this.rewriter2.insertBefore(ctx.getStart(), "<div style=\"background-color:pink;\" class= parexpr"+ par+">");
                this.rewriter2.insertAfter(ctx.getStop(), "</div>");
            }
        }
    }


    
    int z=1;
    int i=0;
    int g=0;
    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {

        // this.rewriter2.insertBefore(ctx.getStart(), "" + x++ + "\">");

        if(y==2){
            int x=1;

            if(ctx.getText().startsWith("{")) {
                if(g==0){g=1;}

                else{
                    z=z+1;
                    this.rewriter2.insertBefore(ctx.getStart(), "<div style=\"background-color:red;\" class= block"+ z+">");
                    this.rewriter2.insertAfter(ctx.getStop(), "</div>");
                }}
        }
        if(y==1){
            if(ctx.getText().startsWith("{")) {

                c=c+1;
                this.rewriter.insertAfter(ctx.getStart(),"c ="+c+";");
                this.rewriter.insertAfter(ctx.getStart(),
                        " try {\n" +

                                "            Writer output2 = null;\n" +
                                "            File file = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\output1.java\");\n" +
                                "            output2 = new BufferedWriter(new FileWriter(file, true));\n" +
                                "            output2.write(\"block number \"+ c+\"\\n\");\n" +
                                "              output2.close();\n" +
                                "        } catch (IOException e) {\n" +
                                "            throw new RuntimeException(e);\n" +
                                "        }"+
                                " try {\n" +

    int blockNumber= 1;
    int blocks=1;
    @Override
    public void enterStatement(JavaParser.StatementContext ctx) {
        // int lastOrIndex = ctx.forControl().expression().getText().lastIndexOf("||");

        if(y==1){


            if(ctx.FOR() != null || ctx.WHILE() != null || ctx.IF() != null)
            {blockNumber++;

                int statementIndex = 0;

                if(!ctx.statement(statementIndex).getStart().getText().equals("{"))
                {String colorGreen = " {try {\n" +

                        "            Writer output4 = null;\n" +
                        "            File file2 = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\wcss.css\");\n" +
                        "            output4 = new BufferedWriter(new FileWriter(file2, true));\n" +

                        " output4.write(\".parexpr\"+" + blockNumber + "+\"{background-color: LimeGreen!important;}\");" +


                        "              output4.close();\n" +
                        "        } catch (IOException e) {\n" +
                        "            throw new RuntimeException(e);\n" +
                        "        }";

                    rewriter.insertBefore(ctx.statement(statementIndex).getStart(), colorGreen);

                    rewriter.insertAfter(ctx.statement(statementIndex).getStop(), "\n\t}\n");

                }

                else{
                    String expression = "";
                   /* if (ctx.FOR() != null)
                    {

                        expression  = ctx.forControl().expression().getText().trim();
                    }*/
                     if(ctx.WHILE() != null || ctx.IF() != null)
                    {
                        expression = ctx.parExpression().expression().getText().trim();
                    }
                   // (x==0||e=0||z==i)
                    int lastor = expression.lastIndexOf("||");//5
                    if (lastor != -1)
                    {
                        String newExpr = expression.substring(0, lastor);

                        String colorOrange =" try {\n" +

                                "            Writer output4 = null;\n" +
                                "            File file2 = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\wcss.css\");\n" +
                                "            output4 = new BufferedWriter(new FileWriter(file2, true));\n" +

                                "  output4.write(\".parexpr\"+" + blockNumber+"+\"{background-color: orange!important;}\");"+


                                "              output4.close();\n" +
                                "        } catch (IOException e) {\n" +
                                "            throw new RuntimeException(e);\n" +
                                "        }";
                        String colorCodeGreen = " try {\n" +

                                "            Writer output4 = null;\n" +
                                "            File file2 = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\wcss.css\");\n" +
                                "            output4 = new BufferedWriter(new FileWriter(file2, true));\n" +

                                " output4.write(\".parexpr\"+" + blockNumber+"+\"{background-color: SpringGreen!important;}\");"+


                                "              output4.close();\n" +
                                "        } catch (IOException e) {\n" +
                                "            throw new RuntimeException(e);\n" +
                                "        }";

                        String Condition = "\n\t\t\tif(" + newExpr + "){\n" +
                                colorOrange + "\n\t\t\t}\n" + "\t\t\telse {\n" + colorCodeGreen + "\n\t\t\t}";

                        rewriter.insertAfter(ctx.statement(0).getStart(), Condition);


                    }else {


                        String colorCodeGreen = " try {\n" +


                                "            Writer output4 = null;\n" +
                                "            File file2 = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\wcss.css\");\n" +
                                "            output4 = new BufferedWriter(new FileWriter(file2, true));\n" +

                                "output4.write(\".block\"+c+\"{\\n\" +\n" +
                                "        \"  background-color: Chartreuse!important;\\n\" +\n" +
                                "        \"}\");"+


                                " output4.write(\".parexpr\"+" + blockNumber + "+\"{background-color: LimeGreen!important;}\");" +



                                "              output4.close();\n" +
                                "        } catch (IOException e) {\n" +
                                "            throw new RuntimeException(e);\n" +

                                "        }"  );}




        }}


                                "        }";
                        rewriter.insertAfter(ctx.statement(0).getStart(), colorCodeGreen);

                    }
                }



            }
            if(ctx.ELSE() != null)
            {
                blockNumber++;
                int statementIndex = 1;
                if(!ctx.statement(statementIndex).getStart().getText().equals("{"))
                {
                    String colorCodeGreen = " {try {\n" +

                            "            Writer output4 = null;\n" +
                            "            File file2 = new File(\"C:\\\\Users\\\\marin\\\\Downloads\\\\grammars-v4-master\\\\grammars-v4-master\\\\java\\\\java\\\\wcss.css\");\n" +
                            "            output4 = new BufferedWriter(new FileWriter(file2, true));\n" +

                            " output4.write(\".parexpr\"+" + blockNumber + "+\"{background-color: LimeGreen!important;}\");" +


                            "              output4.close();\n" +
                            "        } catch (IOException e) {\n" +
                            "            throw new RuntimeException(e);\n" +
                            "        }";

                    rewriter.insertBefore(ctx.statement(statementIndex).getStart(), colorCodeGreen);

                    rewriter.insertAfter(ctx.statement(statementIndex).getStop(), "\n\t}\n");

                }
            }
        }


//int blocks=1;
        if(y==2){
            if(ctx.FOR() != null  || ctx.WHILE() != null || ctx.IF() != null)
            {    blocks++;
                int statementIndex = 0;

                if(!ctx.statement(statementIndex).getStart().getText().equals("{"))
                {

                    rewriter2.insertBefore(ctx.statement(statementIndex).getStart(), "<div style=\"background-color:red;\" class=block"+blocks+">{");

                    rewriter2.insertAfter(ctx.statement(statementIndex).getStop(), "}</div>");
                }
            }

            if(ctx.ELSE() != null)
            {blocks++;
                int statementIndex = 1;

                if(!ctx.statement(statementIndex).getStart().getText().equals("{"))
                {

                    rewriter2.insertBefore(ctx.statement(statementIndex).getStart(), "<div style=\"background-color:red;\" class=block"+blocks+">{");

                    rewriter2.insertAfter(ctx.statement(statementIndex).getStop(), "}</div>");
                }
            }


        }

    }


    
    


}
