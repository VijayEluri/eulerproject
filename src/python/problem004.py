#!/usr/bin/env python

def main():
    n = 999
    for i in range(n*n, 1, -1):
        if not is_palindrome(str(i)):
            continue
        for j in range(n+1, 1, -1):
            if i % j == 0 and i / j <= n:
                print("{} x {} = {}".format(int(i/j), j, i))
                return


def is_palindrome(s):    
    half = int(len(s) / 2)
    for i in range(0, half):
        last = len(s) - 1 - i
        if s[i] != s[last]:
            return False
    return True

    # Shorter
    # return s == s[::-1]


if __name__ == '__main__':
    main()