package it.transcendence.autogene;

import org.apache.commons.lang3.Range;

public class CrisprSystem {
	
	private SequenceTemplate pam;
	private Sequence.End pamPosition;
	private Range<Integer> seqLength;
	
	public CrisprSystem(SequenceTemplate pam, Sequence.End pamPosition, Range<Integer> seqLength) {
		super();
		this.pam = pam;
		this.pamPosition = pamPosition;
		this.seqLength = seqLength;
	}
	
	public final static CrisprSystem Cas9StreptococcusPyogenes = new CrisprSystem (new SequenceTemplate("NRG"), Sequence.End.END3PRIME, Range.between(17, 20));
	public final static CrisprSystem Cas9StaphylococcusAureus = new CrisprSystem (new SequenceTemplate("NNGRRN"), Sequence.End.END3PRIME, Range.between(17, 21));
	public final static CrisprSystem Cpf1Cas12aAcidaminococcusSpAsCpf1WT = new CrisprSystem (new SequenceTemplate("TTTV"), Sequence.End.END5PRIME, Range.between(17, 23));
	public final static CrisprSystem Cpf1Cas12aAcidaminococcusSpAsCpf1RVR = new CrisprSystem (new SequenceTemplate("TVTV"), Sequence.End.END5PRIME, Range.between(17, 23));
	public final static CrisprSystem Cpf1Cas12aAcidaminococcusSpAsCpf1RR = new CrisprSystem (new SequenceTemplate("TYCV"), Sequence.End.END5PRIME, Range.between(17, 23));
	public final static CrisprSystem Mad7Cas12aEubacteriumRectale = new CrisprSystem (new SequenceTemplate("YTTN"), Sequence.End.END5PRIME, Range.between(17, 21));

	public SequenceTemplate getPam() {
		return pam;
	}



	public void setPam(SequenceTemplate pam) {
		this.pam = pam;
	}



	public Sequence.End getPamPosition() {
		return pamPosition;
	}



	public void setPamPosition(Sequence.End pamPosition) {
		this.pamPosition = pamPosition;
	}



	public Range<Integer> getSeqLength() {
		return seqLength;
	}



	public void setSeqLength(Range<Integer> seqLength) {
		this.seqLength = seqLength;
	}


}
