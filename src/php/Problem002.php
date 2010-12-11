<?php

function problem002($upper) {
	$sum = 0;
	$prev = 1;
	$n = 2;
	while ($n <= $upper) {
		if ($n % 2 == 0) {
			$sum += $n;
		}
		$tmp = $n;
		$n = $prev + $n;
		$prev = $tmp;
	}
	return $sum;
}

$result = problem002(4000000);
echo "$result\n";