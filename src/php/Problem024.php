<?php

function recur($index, $digits, $answer, $current = "", $current_index = 0) {

	for ($i = 0; $i < count($digits); $i++) {

		if (count($answer) > 0) {
			break;
		}

		$sequence = $current . $digits[$i];

		$copy = $digits;
		unset($copy[$i]);
		$copy = array_values($copy);

		if (count($copy) == 1) {
			if ($current_index == $index) {
				$answer[] = $sequence . $copy[0];
			}
			$current_index++;
		} else {
			$current_index = recur($index, &$copy, &$answer, &$sequence, $current_index);
		}
	}

	return $current_index;
}

/**
 * Solve using recursivity. Slow in PHP.
 */
function problem024($index, $digits) {
	$answer = array();
	recur($index - 1, str_split($digits), &$answer);
	return $answer[0];
}

$result = problem024(1000000, "0123456789");
echo "$result\n";


