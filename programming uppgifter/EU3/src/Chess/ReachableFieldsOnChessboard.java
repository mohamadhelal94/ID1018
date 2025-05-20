package Chess;

public class ReachableFieldsOnChessboard {
	public static void main(String[] args) throws Chessboard.Chesspiece.NotValidFieldException {
		Chessboard chessBoard = new Chessboard();

		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
		pieces[0] = chessBoard.new Pawn('w', 'P');
		pieces[1] = chessBoard.new Rook('b', 'R');
		pieces[2] = chessBoard.new Queen('w', 'Q');
		pieces[3] = chessBoard.new Bishop('w', 'B');
		pieces[4] = chessBoard.new King('b', 'K');
		pieces[5] = chessBoard.new Knight('w', 'N');

		// Show all the pieces and their markings as well as unmarking
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].moveTo('d', (byte) (4));
			pieces[i].markReachableFields();
			System.out.println(chessBoard + "\n");
			pieces[i].unmarkReachableFields();
			System.out.println(chessBoard + "\n");
			pieces[i].moveOut();

		}
	}
}
