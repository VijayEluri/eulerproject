<?php

	function problem001($upper) {
		$total = 0;
		for ($i = 3; $i < $upper; $i++) {
			if ($i % 3 == 0 or $i % 5 == 0) {
				$total += $i;
			}
		}
		return $total;		
	}

	$res = problem001(1000);
	echo "$res\n";
?>
