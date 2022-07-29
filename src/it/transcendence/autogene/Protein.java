package it.transcendence.autogene;

import java.util.ArrayList;
import java.util.HashMap;

public class Protein {
	
	public static enum A {
		ALA,
		CYS,
		ASP,
		GLU,
		PHE,
		GLY,
		HIS,
		ILE,
		LYS,
		LEU,
		MET,
		ASN,
		PYL,
		PRO,
		GLN,
		ARG,
		SER,
		THR,
		SEC,
		VAL,
		TRP,
		TYR
	}
	
	private static HashMap<A, String> code1 = new HashMap<A, String>() {
	    {
	    	put(A.ALA, "A");
	    	put(A.CYS, "C");
	    	put(A.ASP, "D");
	    	put(A.GLU, "E");
	    	put(A.PHE, "F");
	    	put(A.GLY, "G");
	    	put(A.HIS, "H");
	    	put(A.ILE, "I");
	    	put(A.LYS, "K");
	    	put(A.LEU, "L");
	    	put(A.MET, "M");
	    	put(A.ASN, "N");
	    	put(A.PYL, "O");
	    	put(A.PRO, "P");
	    	put(A.GLN, "Q");
	    	put(A.ARG, "R");
	    	put(A.SER, "S");
	    	put(A.THR, "T");
	    	put(A.SEC, "U");
	    	put(A.VAL, "V");
	    	put(A.TRP, "W");
	    	put(A.TYR, "Y");
	    }
	};
	
	public static String code3(A a) {
		return a.toString();
	}
	
	public static String code1(A a) {
		return code1.get(a);
	}
	
	private ArrayList<A> sequence;
	
	public Protein() {
		// TODO Auto-generated constructor stub
	}

}
