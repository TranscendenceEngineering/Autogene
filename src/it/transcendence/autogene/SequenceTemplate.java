package it.transcendence.autogene;

import java.util.BitSet;
import java.util.HashMap;

public class SequenceTemplate extends Sequence {
	
	private BitSet sequence;
	private int length;
	
	public final static BitSet a = BitSet.valueOf(new byte[] {0b0001});
	public final static BitSet t = BitSet.valueOf(new byte[] {0b1000});
	public final static BitSet c = BitSet.valueOf(new byte[] {0b0010});
	public final static BitSet g = BitSet.valueOf(new byte[] {0b0100});
	public final static BitSet r = BitSet.valueOf(new byte[] {0b0101});
	public final static BitSet y = BitSet.valueOf(new byte[] {0b1010});
	public final static BitSet k = BitSet.valueOf(new byte[] {0b1100});
	public final static BitSet m = BitSet.valueOf(new byte[] {0b0011});
	public final static BitSet s = BitSet.valueOf(new byte[] {0b0110});
	public final static BitSet w = BitSet.valueOf(new byte[] {0b1001});
	public final static BitSet b = BitSet.valueOf(new byte[] {0b1110});
	public final static BitSet d = BitSet.valueOf(new byte[] {0b1101});
	public final static BitSet h = BitSet.valueOf(new byte[] {0b1011});
	public final static BitSet v = BitSet.valueOf(new byte[] {0b0111});
	public final static BitSet n = BitSet.valueOf(new byte[] {0b1111});
	public final static BitSet gap = BitSet.valueOf(new byte[] {0b0000});
	
	HashMap<BitSet, BitSet> inv = new HashMap<BitSet, BitSet>() {
		{
			put(a, t);
			put(t, a);
			put(c, g);
			put(g, c);
			put(r, y);
			put(y, r);
			put(k, m);
			put(m, k);
			put(s, s);
			put(w, w);
			put(b, v);
			put(v, b);
			put(d, h);
			put(h, d);
			put(n, n);
			put(gap, n);
		}
	};
	
	private static HashMap<String, BitSet> code = new HashMap<String, BitSet>() {
		{
			put("A", a);
			put("a", a);
			put("T", t);
			put("t", t);
			put("U", t);
			put("u", t);
			put("C", c);
			put("c", c);
			put("G", g);
			put("g", g);
			put("R", r);
			put("r", r);
			put("Y", y);
			put("y", y);
			put("K", k);
			put("k", k);
			put("M", m);
			put("m", m);
			put("S", s);
			put("s", s);
			put("W", w);
			put("w", w);
			put("B", b);
			put("b", b);
			put("D", d);
			put("d", d);
			put("H", h);
			put("h", h);
			put("V", v);
			put("v", v);
			put("N", n);
			put("n", n);
			put("-", gap);
		}
	};
	
	private static HashMap<BitSet, String> invCode = new HashMap<BitSet, String>(){
		{
			put(a, "A");
			put(t, "T");
			put(c, "C");
			put(g, "G");
			put(r, "R");
			put(y, "Y");
			put(k, "K");
			put(m, "M");
			put(s, "S");
			put(w, "W");
			put(b, "B");
			put(d, "D");
			put(h, "H");
			put(v, "V");
			put(n, "N");
			put(gap, "-");
		}
	};
	
	public SequenceTemplate(String s) {
		// TODO Auto-generated constructor stub
		sequence = encode(s);
		length = s.length();
	}
	
	public SequenceTemplate(BitSet sequence, int length) {
		this.sequence = sequence;
		this.length = length;
	}
	
	public void print(BitSet bits) {
		for(int i=0; i<bits.length()+1; i++) {
			if(bits.get(i)) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
		System.out.println("");
	}
	
	private BitSet reverse(BitSet bits, int length) {
		int l = length*4;
		print(bits);
		BitSet reverse = new BitSet(l);
		for(int i=0; i<l; i+=4) {
			BitSet s = bits.get(i, i+4);
			s = inv.get(s);
			reverse.set(l-i-4, s.get(0));
			reverse.set(l-i-3, s.get(1));
			reverse.set(l-i-2, s.get(2));
			reverse.set(l-i-1, s.get(3));
		}
		print(reverse);
		return reverse;
	}
	
	public BitSet reverseSeq() {
		BitSet rs = reverse(this.sequence, this.length);
		return rs;
	}
	
	public BitSet encode(String s) {
		BitSet sequence = new BitSet(s.length()*4);
		for (int i = 0; i < s.length(); i++){
		    String c = s.substring(i, i+1);
		    BitSet base = code.get(c);
		    sequence.set(4*i, base.get(0));
		    sequence.set(4*i+1, base.get(1));
		    sequence.set(4*i+2, base.get(2));
		    sequence.set(4*i+3, base.get(3));
		}
		return sequence;
	}
	
	public String decode(BitSet seq, int length) {
		String s = new String();
		int l = 4 * length;
		for(int i=0; i<l; i+=4) {
			BitSet base = seq.get(i, i+4);
			String c = invCode.get(base);
			s = s + c;
		}
		return s;
	}
	
	public DNASequence subsequence(int offset, int length) {
		BitSet subs = this.sequence.get(4*offset, 4*(offset+length));
		return new DNASequence(subs, length);
	}
	
	public static void main(String[] args) {
		String s = "A-GGTTTR";
		System.out.println(s);
		SequenceTemplate dna = new SequenceTemplate(s);
		String rs = dna.decode(dna.sequence, dna.length);
		System.out.println(rs);
		String inv = dna.decode(dna.reverseSeq(), dna.length);
		System.out.println(inv);
		byte[] bytes = dna.sequence.toByteArray();
	}

}
