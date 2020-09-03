<?php
 if (isset($_GET['kartica'])&& isset($_GET['bodovi'])) {
 $kartica=$_GET['kartica'];
 $bodovi=$_GET['bodovi'];
 if($kartica=="true" &&  $bodovi=="true") echo "4";
 else  
	 if($kartica=="true" &&  $bodovi=="false") echo "3";
     else
		  if($kartica=="false" &&  $bodovi=="true") echo "2";
	      else
			  if($kartica=="false" &&  $bodovi=="false") echo "1";
 }
 else echo "5";
?>
