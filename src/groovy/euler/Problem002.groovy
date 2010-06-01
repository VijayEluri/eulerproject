package euler;

start = System.currentTimeMillis();

sum = 0;
prev = 1;
n = 2;
while (n <= 4000000) {
    if (n%2 == 0) {
        sum += n;
    }
    tmp = n;
    n = prev + n;
    prev = tmp;
}

System.out.println((System.currentTimeMillis() - start) + " ms");
System.out.println(sum);