import org.antlr.v4.runtime.TokenStreamRewriter;

public class MyStatementsListener extends JavaParserBaseListener{
    int x = 1;
    TokenStreamRewriter rewriter;

    MyStatementsListener(TokenStreamRewriter rewriter) {

        this.rewriter = rewriter;
    }

    @Override
    public void enterStatement(JavaParser.StatementContext ctx) {
        //System.out.println(ctx.expression(0));
        if(ctx.getText().startsWith("if")||ctx.getText().startsWith("else")) {
            this.rewriter.insertBefore(ctx.getStart(), " //block number " + x++ + "\n");
        }

    }


}
