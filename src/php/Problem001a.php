<?php

	function problem001($upper) {
		
		$r3 = range(3, $upper - 1, 3);
		$r5 = range(5, $upper - 1, 5);

		$a = array_merge($r3, $r5);
		$a = array_unique($a);

		return array_reduce($a, function($v, $w) {
				 $v += $w;
				 return $v;
			}
		);
	}

	$res = problem001(1000);
	echo "$res\n";
?>
