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

}
