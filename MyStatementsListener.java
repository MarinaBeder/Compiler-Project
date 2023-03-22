import org.antlr.v4.runtime.TokenStreamRewriter;

public class MyStatementsListener extends StatementsBaseListener{
    int x=1;
    TokenStreamRewriter rewriter;

    MyStatementsListener(TokenStreamRewriter rewriter) {

        this.rewriter = rewriter;
    }
    @Override
    public void enterIf_Statement(StatementsParser.If_StatementContext ctx) {
       System.out.print("if (");
        //this.rewriter.insertBefore(ctx.getStart());
        //this.rewriter.insertAfter(ctx.getStop(), ctx.getText());
 }
    @Override
    public void enterCondition(StatementsParser.ConditionContext ctx) {
        System.out.print(ctx.getText()+")" );
        //System.out.println(ctx.getText());

    }
    @Override
    public void enterBody_if(StatementsParser.Body_ifContext ctx) {
        this.rewriter.insertBefore(ctx.getStart()," //block number "+x+"\n");
        System.out.println("{"+" //block number "+x++);
        //this.rewriter.insertAfter(ctx.getStop(), " //block number "+x++);

    }
@Override
    public void enterBody_if_one(StatementsParser.Body_if_oneContext ctx) {
        this.rewriter.insertBefore(ctx.getStart()," //block number "+x+"\n");

        System.out.println(" //block number "+x++);

    }
    @Override
    public void enterPrint(StatementsParser.PrintContext ctx) { //print() or assignmnet
        System.out.print(ctx.getText());
    }

    @Override
    public void enterPrint_one_line(StatementsParser.Print_one_lineContext ctx) {
        System.out.print(ctx.getText());
    }

    @Override
    public void exitBody_if(StatementsParser.Body_ifContext ctx) {
        System.out.println("}");
    }
}
