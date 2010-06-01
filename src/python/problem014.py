#!/usr/bin/env python
#euler14/py
#Which starting number, under one million, produces the longest chain?

def main():
    LongChain = 0
    TotalChain = 0
    GreatN = 0
    n = 3
    chain = 1
    while n < 1000000:
        x = n
        chain = 0
        while x != 1:
            if x % 2 == 0:
                x = x/2
                chain += 1
            else:
                x = (3 * x) + 1
                chain += 1
            TotalChain = chain
            if TotalChain > LongChain:
                LongChain = TotalChain
                GreatN = n
        n += 1
    print LongChain
    print GreatN
    
if __name__ == '__main__':
    main()
    
