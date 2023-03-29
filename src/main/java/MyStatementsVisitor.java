import org.antlr.v4.runtime.TokenStreamRewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyStatementsVisitor extends JavaParserBaseVisitor{
    Map<String,Integer> variableValuesMap=new HashMap<String,Integer>();
    ArrayList<String>arrayList=new ArrayList<String>();
    int count = 1;
    TokenStreamRewriter rewriter;

    MyStatementsVisitor(TokenStreamRewriter rewriter) {

        this.rewriter = rewriter;
    }



    @Override// a=5
    public Object visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {

        String variable = ctx.variableDeclaratorId().getText();//a
        int intVal=Integer.valueOf(ctx.variableInitializer().getText()) ;//5
        //System.out.println("intVal :"+intVal+(intVal==9));
        //System.out.println("variable"+variable+(variable.equals("a")));
        variableValuesMap.put(variable, intVal);//map[a]=5
        return 0;
    }
@Override
    public Object visitParExpression(JavaParser.ParExpressionContext ctx) {
        int x=1;

        String oper=String.valueOf(ctx.expression().EQUAL());//==
        String OR=String.valueOf(ctx.expression().OR());//

        if(OR.contains("")) {
               //part1
            String FirstExpr= String.valueOf(ctx.expression().expression(0).expression(0).getText());
            int SecondExpr= Integer.valueOf(ctx.expression().expression(0).expression(1).getText());
            int firstExper=variableValuesMap.get(FirstExpr);

            //part2
            String exp1= String.valueOf(ctx.expression().expression(1).expression(0).getText());
            int exp2= Integer.parseInt(ctx.expression().expression(1).expression(1).getText());
            int firstexp1=variableValuesMap.get(exp1);


            if ((firstExper==SecondExpr)||(firstexp1 == exp2)) {
                // this.rewriter.insertBefore(ctx.getStart(), " //block number " + count++ + " Visited\n");
                arrayList.add("block number " + count++ + " Visited\n");
            }

        }
        else if(oper.equals("==")){
            String firstExper= String.valueOf(ctx.expression().expression(0).getText());//a
            int SecondExpr= Integer.parseInt(ctx.expression().expression(1).getText());//5
            int firstexp1=variableValuesMap.get(firstExper);
           if(firstexp1==SecondExpr){
                // this.rewriter.insertBefore(ctx.getStart(), " //block number " + count++ +" Visited\n");
                arrayList.add("block number " + count++ + " Visited\n");

            }


        }
        return 0;}
    public Object visitExpression(JavaParser.ExpressionContext ctx) {
        //String SecondExpr2= String.valueOf(ctx.ASSIGN());
        String FirstExpr= String.valueOf(ctx.expression(0).getText());
        int SecondExpr= Integer.valueOf(ctx.expression(1).getText());
        variableValuesMap.put(FirstExpr,SecondExpr);
        return 0;
    }
}
