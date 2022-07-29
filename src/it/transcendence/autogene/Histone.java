package it.transcendence.autogene;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import it.transcendence.autogene.Protein.A;

import java.util.AbstractMap.SimpleEntry;

public class Histone {
	
	private HashMap<SubUnit, HashMap<Byte, SimpleEntry<Mod, Byte>>> mods = new HashMap<SubUnit,HashMap<Byte, SimpleEntry<Mod, Byte>>>();

	public Histone() {
		// TODO Auto-generated constructor stub
		this.mods.put(SubUnit.H2A, new HashMap<Byte, SimpleEntry<Mod, Byte>>());
		this.mods.put(SubUnit.H2B, new HashMap<Byte, SimpleEntry<Mod, Byte>>());
		this.mods.put(SubUnit.H3, new HashMap<Byte, SimpleEntry<Mod, Byte>>());
		this.mods.put(SubUnit.H4, new HashMap<Byte, SimpleEntry<Mod, Byte>>());
	}
	
	public static enum Mod {
		ME,	//methylation
		AC,	//acetylation
		CI,	//citrullination
		UB,	//ubiquitination
		P,	//phosphorylation
		SER,//serotonylation
		PR,	//propionylation
		BU,	//butyrylation
		CR	//crotonylation
	}
	
	public static enum SubUnit {
		H2A,
		H2B,
		H3,
		H4
	}
	
	public static class SingleMod{
		
		private SubUnit subUnit;
		private byte position;
		private Mod modification;
		private byte cardinality;
		
		public SingleMod(SubUnit subUnit, byte position, Mod modification, byte cardinality) {
			this.subUnit = subUnit;
			this.position = position;
			this.modification = modification;
			this.cardinality = cardinality;
		}
		
		public SingleMod() {
			// TODO Auto-generated constructor stub
		}

		public SubUnit getSubUnit() {
			return subUnit;
		}
		public void setSubUnit(SubUnit subUnit) {
			this.subUnit = subUnit;
		}
		public byte getPosition() {
			return position;
		}
		public void setPosition(byte position) {
			this.position = position;
		}
		public Mod getModification() {
			return modification;
		}
		public void setModification(Mod modification) {
			this.modification = modification;
		}
		public byte getCardinality() {
			return cardinality;
		}
		public void setCardinality(byte cardinality) {
			this.cardinality = cardinality;
		}
	}
	
	private static HashMap<Integer, HashSet<Mod>> h2aLegalMods() {
		HashMap<Integer, HashSet<Mod>> legalMods = new HashMap<Integer, HashSet<Mod>>();
		legalMods.put(1, new HashSet<Mod>());
		legalMods.get(1).add(Mod.P);
		legalMods.put(5, new HashSet<Mod>());
		legalMods.get(5).add(Mod.AC);
		legalMods.put(9, new HashSet<Mod>());
		legalMods.get(9).add(Mod.AC);
		legalMods.put(12, new HashSet<Mod>());
		legalMods.get(12).add(Mod.AC);
		legalMods.put(15, new HashSet<Mod>());
		legalMods.get(15).add(Mod.UB);
		legalMods.put(119, new HashSet<Mod>());
		legalMods.get(119).add(Mod.UB);
		return legalMods;
	}
	private static HashMap<Integer, HashSet<Mod>> h2bLegalMods() {
		HashMap<Integer, HashSet<Mod>> legalMods = new HashMap<Integer, HashSet<Mod>>();
		legalMods.put(5, new HashSet<Mod>());
		legalMods.get(5).add(Mod.AC);
		legalMods.put(12, new HashSet<Mod>());
		legalMods.get(12).add(Mod.AC);
		legalMods.put(14, new HashSet<Mod>());
		legalMods.get(14).add(Mod.P);
		legalMods.put(15, new HashSet<Mod>());
		legalMods.get(15).add(Mod.AC);
		legalMods.put(20, new HashSet<Mod>());
		legalMods.get(20).add(Mod.AC);
		legalMods.put(23, new HashSet<Mod>());
		legalMods.get(23).add(Mod.ME);
		legalMods.put(24, new HashSet<Mod>());
		legalMods.get(24).add(Mod.AC);
		legalMods.put(120, new HashSet<Mod>());
		legalMods.get(120).add(Mod.AC);
		legalMods.get(120).add(Mod.UB);
		return legalMods;
	}
	private static HashMap<Integer, HashSet<Mod>> h3LegalMods() {
		HashMap<Integer, HashSet<Mod>> legalMods = new HashMap<Integer, HashSet<Mod>>();
		legalMods.put(2, new HashSet<Mod>());
		legalMods.get(2).add(Mod.ME);
		legalMods.get(2).add(Mod.CI);
		legalMods.put(3, new HashSet<Mod>());
		legalMods.get(3).add(Mod.P);
		legalMods.put(4, new HashSet<Mod>());
		legalMods.get(4).add(Mod.ME);
		legalMods.get(4).add(Mod.AC);
		legalMods.put(5, new HashSet<Mod>());
		legalMods.get(5).add(Mod.SER);
		legalMods.put(8, new HashSet<Mod>());
		legalMods.get(8).add(Mod.ME);
		legalMods.get(8).add(Mod.CI);
		legalMods.put(9, new HashSet<Mod>());
		legalMods.get(9).add(Mod.ME);
		legalMods.get(9).add(Mod.AC);
		legalMods.put(10, new HashSet<Mod>());
		legalMods.get(10).add(Mod.P);
		legalMods.put(11, new HashSet<Mod>());
		legalMods.get(11).add(Mod.P);
		legalMods.put(14, new HashSet<Mod>());
		legalMods.get(14).add(Mod.ME);
		legalMods.get(14).add(Mod.AC);
		legalMods.get(14).add(Mod.PR);
		legalMods.get(14).add(Mod.BU);
		legalMods.put(17, new HashSet<Mod>());
		legalMods.get(17).add(Mod.ME);
		legalMods.put(18, new HashSet<Mod>());
		legalMods.get(18).add(Mod.AC);
		legalMods.put(23, new HashSet<Mod>());
		legalMods.get(23).add(Mod.ME);
		legalMods.get(23).add(Mod.AC);
		legalMods.put(26, new HashSet<Mod>());
		legalMods.get(26).add(Mod.ME);
		legalMods.put(27, new HashSet<Mod>());
		legalMods.get(27).add(Mod.ME);
		legalMods.get(27).add(Mod.AC);
		legalMods.put(28, new HashSet<Mod>());
		legalMods.get(28).add(Mod.ME);
		legalMods.put(36, new HashSet<Mod>());
		legalMods.get(36).add(Mod.ME);
		legalMods.get(36).add(Mod.AC);
		return legalMods;
	}
	private static HashMap<Integer, HashSet<Mod>> h4LegalMods() {
		HashMap<Integer, HashSet<Mod>> legalMods = new HashMap<Integer, HashSet<Mod>>();
		legalMods.put(1, new HashSet<Mod>());
		legalMods.get(1).add(Mod.P);
		legalMods.put(3, new HashSet<Mod>());
		legalMods.get(3).add(Mod.ME);
		legalMods.get(3).add(Mod.CI);
		legalMods.put(5, new HashSet<Mod>());
		legalMods.get(5).add(Mod.AC);
		legalMods.put(8, new HashSet<Mod>());
		legalMods.get(8).add(Mod.AC);
		legalMods.put(12, new HashSet<Mod>());
		legalMods.get(12).add(Mod.ME);
		legalMods.get(12).add(Mod.AC);
		legalMods.put(16, new HashSet<Mod>());
		legalMods.get(16).add(Mod.AC);
		legalMods.put(18, new HashSet<Mod>());
		legalMods.get(18).add(Mod.P);
		legalMods.put(20, new HashSet<Mod>());
		legalMods.get(20).add(Mod.ME);
		legalMods.get(20).add(Mod.AC);
		return legalMods;
	}
	
	private static HashMap<Integer, HashSet<Mod>> h2aLegalMods = h2aLegalMods();
	private static HashMap<Integer, HashSet<Mod>> h2bLegalMods = h2bLegalMods();
	private static HashMap<Integer, HashSet<Mod>> h3LegalMods = h3LegalMods();
	private static HashMap<Integer, HashSet<Mod>> h4LegalMods = h4LegalMods();
	
	private static HashMap<Integer, Protein.A> h2aSeq = new HashMap<Integer, Protein.A>(){
		{
			put(1, A.SER);
			put(5, A.LYS);
			put(9, A.LYS);
			put(12, A.ALA);
			put(15, A.LYS);
			put(119, A.LYS);
		}
	};
	private static HashMap<Integer, Protein.A> h2bSeq = new HashMap<Integer, Protein.A>(){
		{
			put(5, A.LYS);
			put(12, A.LYS);
			put(14, A.SER);
			put(15, A.LYS);
			put(20, A.LYS);
			put(23, A.LYS);
			put(24, A.LYS);
			put(120, A.LYS);
		}
	};
	private static HashMap<Integer, Protein.A> h3Seq = new HashMap<Integer, Protein.A>(){
		{
			put(2, A.ARG);
			put(3, A.THR);
			put(4, A.LYS);
			put(5, A.GLN);
			put(8, A.ARG);
			put(9, A.LYS);
			put(10, A.SER);
			put(11, A.THR);
			put(14, A.LYS);
			put(17, A.ARG);
			put(18, A.LYS);
			put(23, A.LYS);
			put(26, A.ARG);
			put(27, A.LYS);
			put(28, A.SER);
			put(36, A.LYS);
		}
	};
	private static HashMap<Integer, Protein.A> h4Seq = new HashMap<Integer, Protein.A>(){
		{
			put(1, A.SER);
			put(3, A.ARG);
			put(5, A.LYS);
			put(8, A.LYS);
			put(12, A.LYS);
			put(16, A.LYS);
			put(18, A.HIS);
			put(20, A.LYS);
		}
	};
	
	private static Boolean isLegalMod(SubUnit subUnit, int position, Mod modification, int cardinality) {
		HashMap<Integer, HashSet<Mod>> legalMods = new HashMap<Integer, HashSet<Mod>>();
		switch(subUnit) {
		case H2A:
			legalMods = h2aLegalMods;
			break;
		case H2B:
			legalMods = h2bLegalMods;
			break;
		case H3:
			legalMods = h3LegalMods;
			break;
		case H4:
			legalMods = h4LegalMods;
			break;
		}
		if(! legalMods.keySet().contains(position)) {
			return false;
		}
		if(legalMods.get(position).contains(modification)) {
			if(modification==Mod.ME) {
				return (cardinality<=3);
			} else {
				return (cardinality<=1);
			}
		}
		return false;
	}
	
	private static HashMap<SubUnit, HashMap<Integer, Protein.A>> sequences = new HashMap<SubUnit, HashMap<Integer, Protein.A>>(){
		{
			put(SubUnit.H2A, h2aSeq);
			put(SubUnit.H2B, h2bSeq);
			put(SubUnit.H3, h3Seq);
			put(SubUnit.H4, h4Seq);
		}
	};
	
	private static String encodeValidMod(SubUnit subUnit, int position, Mod modification, int cardinality) {
		String s = "";
		s += subUnit.toString();
		s += Protein.code1(sequences.get(subUnit).get(position));
		s += position;
		s += modification.toString().toLowerCase();
		s += cardinality;
		return s;
	}
	
	private static String encodeValidMod(SingleMod mod) {
		return encodeValidMod(mod.getSubUnit(), (int) mod.getPosition(), mod.getModification(), (int) mod.getCardinality());
	}
	
	public static String encodeMod(SubUnit subUnit, int position, Mod modification, int cardinality) {
		if(isLegalMod(subUnit, position, modification, cardinality)) {
			return encodeValidMod(subUnit, position, modification, cardinality);
		} else {
			return "";
		}
	}
	
	public static String encodeMod(SingleMod mod) {
		return encodeMod(mod.getSubUnit(), (int) mod.getPosition(), mod.getModification(), (int) mod.getCardinality());
	}
	
	private static SingleMod decodeVelidMod(String s) {
		SingleMod mod = new SingleMod();
		if(s.startsWith("H2A")){
			mod.setSubUnit(SubUnit.H2A);
			s = s.substring(4);
		} else if(s.startsWith("H2B")){
			mod.setSubUnit(SubUnit.H2B);
			s = s.substring(4);
		} else if(s.startsWith("H3")){
			mod.setSubUnit(SubUnit.H3);
			s = s.substring(3);
		} else if(s.startsWith("H4")) {
			mod.setSubUnit(SubUnit.H4);
			s = s.substring(3);
		} else {
			return new SingleMod();
		}
		
		
		
		return mod;
	}
	
	public void mod(SubUnit subUnit, int position, Mod modification, int cardinality) {
		if (isLegalMod(subUnit, position, modification, cardinality)) {
			this.mods.get(subUnit).put((byte) position, new HashMap.SimpleEntry<Mod, Byte>(modification, (byte) cardinality));
		} else {
			System.out.println("Illegal mod");
		}
	}
	
	public void mod(SingleMod mod) {
		this.mod(mod.getSubUnit(), (int) mod.getPosition(), mod.getModification(), (int) mod.getCardinality());
	}
	
	public void unmod(SubUnit subUnit, int position) {
		this.mods.get(subUnit).remove(position);
	}
	
	public static void main(String[] args) {
		Histone histone = new Histone();
		histone.mod(SubUnit.H2A, 119, Mod.UB, 1);
		System.out.println(histone.mods.get(SubUnit.H2A).get((byte) 119));
	}
}
