package it.transcendence.autogene;

import java.util.BitSet;
import org.apache.commons.lang3.Range;

public abstract class MethilatableSequence extends Sequence {
	
	protected BitSet methilationPattern;
	
	public void methilate(int position) {
		this.methilationPattern.set(position);
	}
	
	public void methilate (Range<Integer> range) {
		this.methilationPattern.set(range.getMinimum(), range.getMaximum() - 1);
	}
	
	public void demethilate(int position) {
		this.methilationPattern.clear(position);
	}
	
	public void demethilate (Range<Integer> range) {
		this.methilationPattern.clear(range.getMinimum(), range.getMaximum() - 1);
	}
	
	public void methilate (BitSet subPattern, int subPatternLength, int offset) {
		for (int i = 0; i < subPatternLength; i++) {
			this.methilationPattern.set(offset + i, subPattern.get(i));
		}
	}
	
	protected BitSet subPattern(int offset, int length) {
		BitSet subs = this.sequence.get(offset, offset+length);
		return subs;
	}
	
	protected BitSet reverseMethilationPattern(BitSet bits, int length) {
		int l = length;
		BitSet reverse = new BitSet(l);
		for(int i=0; i<l; i++) {
			reverse.set(i+1, bits.get(l-i-1));
		}
		return reverse;
	}

	public BitSet getMethilationPattern() {
		return methilationPattern;
	}

	public void setMethilationPattern(BitSet methilationPattern) {
		this.methilationPattern = methilationPattern;
	}
	
	

}
