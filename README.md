# Autogene
An open source tool for whole genome editing

![Logo](autogene_logo.png)

*Project is in a very early stage*

Autogene is an open source Java toolkit developed by Transcendence Engineering for genome- and epigenome-wide editing. The aim of the project is to create an open source algorithm and usable software for automated epi/genetic editing capable of:
1. Automatically design sgRNAs for CRISPR epi/genetic editing given a list of pointwise mutations to be performed
2. Computationally-efficiently evaluate the off-target activity of a given sgRNA given a whole genome
3. Automatically choose, among the possible sgRNA capable of performing a point mutation, the one that minimise the risk of off-target activity

Autogene is written in Java for multiplatform interoperability and security reasons.

## Format
### DNA/RNA Sequence
DNA/RNA Sequences are stored in a BitSet java object encapsulated in the DNASequence class, encoded with 2 bits per base, according to the following table:
| Nucleobase  | Bits |
| ----------- | ---- |
| A | 0b00 |
| T | 0b11 |
| C | 0b01 |
| G | 0b10 |

This encoding scheme is different from the one used in standard 2bit file format, but it make it easier to compute the complementary sequence (it can be computed by bitwise NOT operation)

RNA sequences can be stored the same way considering that T and U bases are the same on a "datalink" (OSI 2) level (i.e. they encode the same information with differences in only physical layer).

Sequence is encoding as little-endian from 5' to 3', given that BitSet object use lowest index for LSB, according to the following scheme:
![Encoding](/img/encoding-scheme.png)

### Histones
Histone modifications are encoded through the Histone class. It comprises enums for the encoding of subunits and modifications and nested HashMap/Sets for storing the modifications themselves. Please read the code itself for further informations.
Supported modifications are:
| enum Mod constant | Modification |
| ----------------- | ------------ |
| ME  | methylation     |
| AC  | acetylation     |
| CI  | citrullination  |
| UB  | ubiquitination  |
| P   | phosphorylation |
| SER | serotonylation  |
| PR  | propionylation  |
| BU  | butyrylation    |
| CR  | crotonylation   |

## Collaborations
If you or your institution are interested in collaborating with this project, please send an email to info[at]transcendence.it
