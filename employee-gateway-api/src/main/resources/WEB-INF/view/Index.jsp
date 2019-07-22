<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<script>  
	function prepareUrl(){ 
		var source=document.searchRouteform.source.value;  
		var destination=document.searchRouteform.destination.value;
		var travelType=document.searchRouteform.destination.value;
		
		if (source==null || source==""){  
		  alert("source can't be blank");  
		  return false;  
		}else if (destination==null || destination==""){  
			  alert("destination can't be blank");  
			  return false;  
		}
		
		var xhr = new XMLHttpRequest();
		var url = "http://localhost:8080/TransportSystem/Transport/shortestRoute/";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.onreadystatechange = function () {
		    if (xhr.readyState === 4 && xhr.status === 200) {
		    	if(!document.searchRouteform.route){
			        var input = document.createElement('input');
			        input.type = 'text';
			        input.name = 'route';
			        input.value = xhr.responseText;
			        document.searchRouteform.appendChild(input);
		    	}else{
		    		document.searchRouteform.route.value = xhr.responseText;
		    	}
		    }
		};
		var data = JSON.stringify({"source": source, "destination": destination});
		xhr.send(data);
	}
	
</script>  
<body style='background-color: #006600;'>
    <div>
        <div bgcolor="#006600">
            <h1>Interstellar Transport System wellcomes you !!</h1>
            <h2> ${message}</h2>
             
            <form name="searchRouteform" method="get" >
				<table style="with: 50%">
		 			<tr>
						<td>Travel Type:</td>
						<td>
							<select name="searchType">
							    <option value="distance">Shortest Distance</option>
							    <option value="time">Shortest Time</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Source Planet ID:</td>
						<td><input type="text" name="source" /></td>
					</tr>
						<tr>
						<td>Destination Planet ID:</td>
						<td><input type="text" name="destination" /></td>
					</tr>
				</table>
				<input type="button" value="Search" onclick="prepareUrl()"/>
			</form>
        </div>
    </div>
</body>
</html>