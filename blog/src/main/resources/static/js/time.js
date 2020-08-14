/**
 * 
 */
window.onload=function () {
		// body...
		setInterval(function(){
		var now=new Date();
		var year=now.getFullYear();
		var month=now.getMonth();
		
		var date=now.getDate();
		if (date<10) {date="0"+date}
		var hour=now.getHours();
		if (hour<10) {hour="0"+hour}
		var minute=now.getMinutes();
		if (minute<10) {minute="0"+minute}
		document.getElementById('year').innerHTML=year+"/";
		document.getElementById('month').innerHTML=(month+1)+"/";
		document.getElementById('day').innerHTML=date;
		document.getElementById('hour').innerHTML=hour;
		document.getElementById('minute').innerHTML=minute; 
	},50); 
		
		
		


	}