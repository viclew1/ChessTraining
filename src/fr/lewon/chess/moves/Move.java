package fr.lewon.chess.moves;

public class Move {

	private int dRow;
	private int dCol;
	private boolean repeatable;
	private boolean canAttack;
	private MoveChecker specificChecks;
	private boolean canMoveTowardEmpty;
	
	public Move(int dRow, int dCol, boolean repeatable, boolean canAttack, boolean canMoveTowardEmpty) {
		this(dRow, dCol, repeatable, canAttack, canMoveTowardEmpty, (b, r, c) -> true);
	}
	
	public Move(int dRow, int dCol, boolean repeatable, boolean canAttack, boolean canMoveTowardEmpty, MoveChecker specificChecks) {
		this.dRow = dRow;
		this.dCol = dCol;
		this.repeatable = repeatable;
		this.canAttack = canAttack;
		this.specificChecks = specificChecks;
		this.canMoveTowardEmpty = canMoveTowardEmpty;
	}

	public int getdRow() {
		return dRow;
	}

	public void setdRow(int dRow) {
		this.dRow = dRow;
	}

	public int getdCol() {
		return dCol;
	}

	public void setdCol(int dCol) {
		this.dCol = dCol;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	public boolean isCanMoveTowardEmpty() {
		return canMoveTowardEmpty;
	}

	public void setCanMoveTowardEmpty(boolean canMoveTowardEmpty) {
		this.canMoveTowardEmpty = canMoveTowardEmpty;
	}

	public MoveChecker getSpecificChecks() {
		return specificChecks;
	}

	public void setSpecificChecks(MoveChecker specificChecks) {
		this.specificChecks = specificChecks;
	}
	
}
