package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}


	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Invalid position");
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {  // Overload, same method, different signature
		if (!positionExists(position)) {
			throw new BoardException("Invalid position");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {  // sets a specific piece to a specific place on the board
		if (thereIsAPiece(position)) {
			throw new BoardException("There is a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; 
	}
	
	public boolean positionExists(int row, int column) {  // valida se a posição é valida do tabuleiro
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {  // retorna se a posição for válida
		return positionExists(position.getRow(), position.getColumn());	
	}
	
	public boolean thereIsAPiece(Position position) {  // valida se existe peça na posição passada.
		if (!positionExists(position)) {
			throw new BoardException("Invalid position");
		}
		return piece(position) != null;
	}
	
	

}
