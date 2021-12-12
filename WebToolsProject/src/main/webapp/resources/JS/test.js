function test(my_data){
	alert('Hello');
	
	$.ajax({
   	url: 'ajaxfile.php',
   	type: 'post',
   	data: my_data,
   	success: function(response){
		alert('hurrraayyy')
   }
});

}