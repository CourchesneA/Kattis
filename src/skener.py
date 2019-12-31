#! /usr/bin/python3
import sys

setup = sys.stdin.readline()
r,c,zr,zc = setup.split()

#for line in sys.stdin:

out = ""
for i in range(int(r)): # For each line of the input matrix
    outline = ""    # output for a single line, should be multiplied by zr
    row = sys.stdin.readline().strip()
    for char in row:
        assert len(char)==1, "Should iterate over character of line" 
        assert char.isalpha or char == '.', "char should be alpha or dot" 
        outline+=char*int(zc)
    outline+="\n"
    out+=outline*int(zr)

print(out)