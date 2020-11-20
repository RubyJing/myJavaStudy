package designpatterns.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 10:44
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1),0, 0));
        chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 0, 1));
        //省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPosX, int toPosY) {
        //..省略..
    }
}
