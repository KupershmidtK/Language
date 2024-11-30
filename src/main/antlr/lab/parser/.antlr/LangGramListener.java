// Generated from /home/kirill/PROGRAMMING/IdeaProjects/Language/src/main/antlr/lab/parser/LangGram.g4 by ANTLR 4.13.1
 package lab.parser; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangGramParser}.
 */
public interface LangGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangGramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LangGramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LangGramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LangGramParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LangGramParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(LangGramParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(LangGramParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(LangGramParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(LangGramParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExp(LangGramParser.IdExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExp(LangGramParser.IdExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(LangGramParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(LangGramParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpr(LangGramParser.PlusMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpr(LangGramParser.PlusMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(LangGramParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(LangGramParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpr(LangGramParser.ParenthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpr(LangGramParser.ParenthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(LangGramParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(LangGramParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(LangGramParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LangGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(LangGramParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(LangGramParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(LangGramParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LangGramParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LangGramParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#compOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompOperator(LangGramParser.CompOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#compOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompOperator(LangGramParser.CompOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#println}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(LangGramParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#println}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(LangGramParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(LangGramParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(LangGramParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LangGramParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LangGramParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(LangGramParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(LangGramParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(LangGramParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(LangGramParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LangGramParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LangGramParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGramParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(LangGramParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGramParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(LangGramParser.ElseStatementContext ctx);
}