
<!DOCTYPE html>
<html>
  <head>
    <style>
    
    

   
#map {
        width: 50%;
        height: 400px;
     }
     
  
   
    </style>
    
     <link rel="stylesheet" href="https://unpkg.com/leaflet@1.8.0/dist/leaflet.css"
   integrity="sha512-hoalWLoI8r4UszCkZ5kL8vayOGVae1oxXe/2A4AO6J9+580uKHDO3JdHb7NzwwzK5xr/Fs0W40kiNHxM9vyTtQ=="
   crossorigin=""/>
   
    <!-- Make sure you put this AFTER Leaflet's CSS -->
 <script src="https://unpkg.com/leaflet@1.8.0/dist/leaflet.js"
   integrity="sha512-BB3hKbKWOc9Ez/TAwyWxNXeoV9c1v6FIeYiBieIWkpLjauysF18NzgR1MBNBXf8/KABdlkX68nAhlwcDFLGPCQ=="
   crossorigin="">
   
   </script>
   <script>
   	function getLatLong() {
		return   {lat: ${model.position.lat}, lng: ${model.position.longitude}};
 
	}
   
   </script>
  </head>
  
  <body onload="showMap();">
	<h1>Vehicle Info for ${model.vehicle.name}</h1>

	<p>The last report for this vehicle was at ${model.position.timestamp}</p>

	<p>It was at lat long ${model.position.lat}, ${model.position.longitude}</p>

    

   
   <div id="map" size="50%"></div>
  
   <script> 
	  function showMap() {
    	  var myLatLng = getLatLong(); 
 	      var map = L.map('map').setView(myLatLng, 13);
      
     	  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
             maxZoom: 19,
             attribution: '© OpenStreetMap'
     	  }).addTo(map);

          var marker = L.marker(myLatLng).addTo(map);
        }
        </script>   
  </body>
</html>
