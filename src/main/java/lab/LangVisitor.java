package lab;

import lab.parser.LangGramBaseVisitor;
import lab.parser.LangGramParser;

import java.util.HashMap;
import java.util.Map;

public class LangVisitor extends LangGramBaseVisitor<Integer> {
    private final Map<String, Integer> memories = new HashMap<>();

    // IDENTIFIER
    @Override
    public Integer visitIdExp(LangGramParser.IdExpContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        if(memories.containsKey(id)) {
            return memories.get(id);
        }
        // return 0;
        throw new RuntimeException("Variable '" + id + "' is not defined.");
    }

    // left=expression op=(PLUS | MINUS) right=expression
    @Override
    public Integer visitPlusMinusExpr(LangGramParser.PlusMinusExprContext ctx) {
        if(ctx.op.getType() == LangGramParser.PLUS) {
            return visit(ctx.left) + visit(ctx.right);
        }
        return visit(ctx.left) - visit(ctx.right);
    }

    // '(' expression ')'
    @Override
    public Integer visitParenthesisExpr(LangGramParser.ParenthesisExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Integer visitMulDivExpr(LangGramParser.MulDivExprContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        if(ctx.op.getType() == LangGramParser.ASTERISK) {
            return left * right;
        }

        if (right == 0)
            throw new RuntimeException("Division by zero.");

        if(ctx.op.getType() == LangGramParser.SLASH) {
            return left / right;
        }

        return left % right;
    }

    // NUMBER
    @Override
    public Integer visitNumExpr(LangGramParser.NumExprContext ctx) {
        return Integer.valueOf(ctx.NUMBER().getText());
    }

    // variableDeclaration: 'var' IDENTIFIER '=' expression ;
    @Override
    public Integer visitVariableDeclaration(LangGramParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        if(memories.containsKey(id)) {
            throw new RuntimeException("Variable '" + id + "' already defined");
        }

        Integer value = visit(ctx.expression());
        memories.put(id, value);
        return value;
    }

    // assignment: IDENTIFIER '=' expression ;
    @Override
    public Integer visitAssignment(LangGramParser.AssignmentContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        if(!memories.containsKey(id)) {
            throw new RuntimeException("Variable '" + id + "' is not defined");
        }

        Integer value = visit(ctx.expression());
        memories.put(id, value);
        return value;
    }

    // left=expression compOperator right=expression
    @Override
    public Integer visitCompExpr(LangGramParser.CompExprContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        return switch (visit(ctx.compOperator())) {
            case LangGramParser.LESS            -> left < right ? 1 : 0;
            case LangGramParser.LESS_OR_EQUAL   -> left <= right ? 1 : 0;
            case LangGramParser.GREATER         -> left > right ? 1 : 0;
            case LangGramParser.GREATER_OR_EQUAL-> left >= right ? 1 : 0;
            case LangGramParser.EQUAL           -> left == right ? 1 : 0;
            case LangGramParser.NOT_EQUAL       -> left != right ? 1 : 0;
            default -> null;
        };
    }

    // compOperator: op=(LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | GREATER | GREATER_OR_EQUAL) ;
    @Override
    public Integer visitCompOperator(LangGramParser.CompOperatorContext ctx) {
        return ctx.op.getType();
    }

    // println: 'println' expression ;
    @Override
    public Integer visitPrintln(LangGramParser.PrintlnContext ctx) {
        System.out.println(visit(ctx.expression()));
        return 0;
    }

    @Override
    public Integer visitBlockStatement(LangGramParser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    // ifStatement: 'if' '(' expression ')' statement  elseStatement? ;
    @Override
    public Integer visitIfStatement(LangGramParser.IfStatementContext ctx) {
        boolean visitFlag = false;
        Integer condition = visit(ctx.expression());

        // if ...
        if (condition != 0) {
            visit(ctx.statement());
            visitFlag = true;
        }

        // else if ...
        if(ctx.elifStatement() != null) {
            for (LangGramParser.ElifStatementContext elifCtx : ctx.elifStatement()) {
                if(visit(elifCtx) != null)
                    visitFlag = true;
            }
        }

        // else ...
        if (ctx.elseStatement() != null && !visitFlag) {
            visit(ctx.elseStatement());
        }

        return null;
    }

    // elseStatement: 'else' statement ;
    @Override
    public Integer visitElseStatement(LangGramParser.ElseStatementContext ctx) {
        return visitChildren(ctx);
    }

    // elifStatement:  'else if' '(' expression ')' statement ;
    @Override
    public Integer visitElifStatement(LangGramParser.ElifStatementContext ctx) {
        Integer condition = visit(ctx.expression());
        if (condition != 0) {
            visit(ctx.statement());
            return 0;
        }
        return null;
    }

    // whileIteration: 'while' '(' expression ')' statement ;
    @Override
    public Integer visitWhileIteration(LangGramParser.WhileIterationContext ctx) {
        while (visit(ctx.expression()) != 0) {
            visit(ctx.statement());
        }
        return null;
    }

    // forIteration: 'for' '(' (variableDeclaration | assignment)? ';' expression ';' assignment? ')' statement ;
    @Override
    public Integer visitForIteration(LangGramParser.ForIterationContext ctx) {
        if (ctx.variableDeclaration() != null) {
            visit(ctx.variableDeclaration());
        }

        while (visit(ctx.expression()) != 0) {
            visit(ctx.statement());

            if (ctx.assignment() != null) {
                visit(ctx.assignment());
            }
        }
        return null;
    }

}
