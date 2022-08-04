package it.transcendence.autogene;

import java.util.BitSet;
import java.util.HashMap;

public abstract class Sequence {
	
	protected BitSet sequence;
	protected int length;
	
	public static enum End {
		END5PRIME,
		END3PRIME
	}

	public Sequence() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract BitSet encode(String s);
	public abstract String decode(BitSet seq, int length);
	public abstract Sequence subsequence(int offset, int length);
	public abstract BitSet complementary_sequence();
	
	
	

	public BitSet getSequence() {
		return sequence;
	}

	public void setSequence(BitSet sequence) {
		this.sequence = sequence;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
