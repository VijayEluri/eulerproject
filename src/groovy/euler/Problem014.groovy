/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package euler

def collatz(n) {
    i = 1
    while (n>1) {
        i++
        if (n.longValue()%2==1) {
            n=3*n+1
        } else {
            n=n/2
        }
    }
    i
}

start = System.currentTimeMillis()

max = 0
n = 0
for (i in 1..999999) {
    l = collatz(i)
    if (l>max) {
        max = l
        n = i
    }
}

println("$max = ($n)")
println((System.currentTimeMillis() - start) + " ms")