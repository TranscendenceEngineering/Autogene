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
DNA/RNA Sequences are stored in a BitSet java object, encoded with 2 bits per base, according to the following table:
| Nucleobase  | Bits |
| ----------- | ---- |
| A | 0b00 |
| T | 0b11 |
| C | 0b01 |
| G | 0b10 |

## Collaborations
If you, or your institution are interested in collaborating in this project, please send an email to info[at]transcendence.it
