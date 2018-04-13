package ru.anmokretsov.calculite

class CalculatorModel {

    private var tokens: List<Token> = ArrayList()

    private fun tokenize(name: String) {

        when (name) {
            Helper.L_PAREN, Helper.R_PAREN -> tokens += Token(name, Token.Type.PARENTHESES)

            in Helper.NUMBERS, Helper.DIVIDER -> if (!tokens.isEmpty() && tokens.last().type == Token.Type.NUMBER)
                tokens.last().value += name else tokens += Token(name, Token.Type.NUMBER)

            Helper.OP_DIV, Helper.OP_MUL, Helper.OP_SUB, Helper.OP_ADD, Helper.OP_SQRT,
            Helper.OP_POW, Helper.OP_FAC, Helper.OP_PERC, Helper.OP_MOD -> tokens += Token(name, Token.Type.OPERATOR)

            Helper.CONST_E -> tokens += Token(Math.E.toString(), Token.Type.CONSTANT)

            Helper.CONST_PI -> tokens += Token(Math.PI.toString(), Token.Type.CONSTANT)

            Helper.FUN_COS, Helper.FUN_DEG, Helper.FUN_LN, Helper.FUN_LOG,
            Helper.FUN_RAD, Helper.FUN_SIN, Helper.FUN_TAN -> tokens += Token(name, Token.Type.FUNCTION)
        }
    }

    private fun tokensToString() : String{
        val builder = StringBuilder()
        for (token in tokens){
            builder.append(token.value)
            if (token.type == Token.Type.FUNCTION)
                builder.append("(")
        }
        return builder.toString()
    }

    fun addElement(element: String, callback: (String) -> Any){
        tokenize(element)
        callback(tokensToString())
    }

}