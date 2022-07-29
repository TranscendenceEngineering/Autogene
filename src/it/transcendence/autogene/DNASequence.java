package it.transcendence.autogene;
import at.favre.lib.bytes.*;
import java.util.BitSet;
import java.util.HashMap;



public class DNASequence{
	
	private BitSet sequence;
	private int length;

	public static BitSet a = BitSet.valueOf(new byte[] {0b00});
	public static BitSet t = BitSet.valueOf(new byte[] {0b11});
	public static BitSet c = BitSet.valueOf(new byte[] {0b01});
	public static BitSet g = BitSet.valueOf(new byte[] {0b10});
	
	private static HashMap<String, BitSet> code(){
		HashMap<String, BitSet> code = new HashMap<String, BitSet>();
		code.put("A", a);
		code.put("a", a);
		code.put("T", t);
		code.put("t", t);
		code.put("C", c);
		code.put("c", c);
		code.put("G", g);
		code.put("g", g);
		return code;
	}
	private static HashMap<BitSet, String> invCode(){
		HashMap<BitSet, String> invCode = new HashMap<BitSet, String>();
		invCode.put(a, "A");
		invCode.put(t, "T");
		invCode.put(c, "C");
		invCode.put(g, "G");
		return invCode;
	}
	private static HashMap<String, BitSet> code = code();
	private static HashMap<BitSet, String> invCode = invCode();
	
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
		int l = length*2;
		print(bits);
		BitSet reverse = new BitSet(l);
		for(int i=0; i<l; i+=2) {
			reverse.set(i, bits.get(l-i-2));
			reverse.set(i+1, bits.get(l-i-1));
		}
		print(reverse);
		reverse.flip(0, l);
		print(reverse);
		return reverse;
	}
	
	public BitSet sequence() {
		return sequence;
	}
	
	public BitSet complementary_sequence() {
		BitSet cs = reverse(sequence, length);
		cs.flip(0, cs.length());
		return cs;
	}
	
	public DNASequence(String s) {
		// TODO Auto-generated constructor stub
		sequence = encode(s);
		length = s.length();
	}
	
	public DNASequence(BitSet sequence, int length) {
		this.sequence = sequence;
		this.length = length;
	}
	
	public BitSet reverseSeq() {
		BitSet rs = reverse(this.sequence, this.length);
		return rs;
	}
	
	public BitSet encode(String s) {
		BitSet sequence = new BitSet(s.length()*2);
		for (int i = 0; i < s.length(); i++){
		    String c = s.substring(i, i+1);        
		    BitSet base = code.get(c);
		    sequence.set(2*i, base.get(0));
		    sequence.set(2*i+1, base.get(1));
		}
		return sequence;
	}
	
	
	public String decode(BitSet seq, int length) {
		String s = new String();
		int l = 2*length;
		for(int i=0; i<l; i+=2) {
			BitSet base = new BitSet(2);
			base.set(0, seq.get(i));
			base.set(1, seq.get(i+1));
			String c = invCode.get(base);
			s = s + c;
		}
		return s;
	}
	
	public DNASequence subsequence(int offset, int length) {
		BitSet subs = this.sequence.get(2*offset, 2*(offset+length));
		return new DNASequence(subs, length);
	}
	
	public int compare(DNASequence subsequence) {
		BitSet xor = (BitSet) this.sequence.clone();
		xor.xor(subsequence.sequence);
		int corrsp = 0;
		for(int i=0; i<subsequence.length; i++) {
			byte b = xor.get(2*i, 2*i+2).toByteArray()[0];
			if(b==0) {
				corrsp++;
			}
		}
		return corrsp;
	}
	
	public HashMap<Integer, Integer> search(DNASequence subsequence, Integer threshold){
		HashMap<Integer, Integer> search = new HashMap<Integer, Integer>();
		for(int i=0; i<(this.length-subsequence.length); i++) {
			Integer comp = this.subsequence(i, subsequence.length).compare(subsequence);
			if(comp >= threshold) {
				search.put(i, comp);
			}
		}
		return search;
	}
	
	public static void main(String[] args) {
		String s = "TCAGTCAGGG";
		System.out.println(s);
		DNASequence dna = new DNASequence(s);
		String rs = dna.decode(dna.sequence, dna.length);
		System.out.println(rs);
		String inv = dna.decode(dna.reverseSeq(), dna.length);
		System.out.println(inv);
	}

}
