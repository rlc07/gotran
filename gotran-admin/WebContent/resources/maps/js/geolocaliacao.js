var x=document.getElementById("demo");
function getLocation()
  {
    
    var cep = $("#cep").val();
    console.log(cep);
	var lat = '';
	var lng = '';
	var address = cep;
	geocoder.geocode( { 'address': address}, function(results, status) {
	  if (status == google.maps.GeocoderStatus.OK) {
	     lat = results[0].geometry.location.lat();
	     lng = results[0].geometry.location.lng();
	  } else {
	     alert("Não foi possivel obter localização: " + status);
	  }
	});
	alert('Latitude: ' + lat + ' Logitude: ' + lng);   
  }
 
function showPosition(position)
  {
  lat=position.coords.latitude;
  lon=position.coords.longitude;
  latlon=new google.maps.LatLng(lat, lon)
  mapholder=document.getElementById('mapholder')
  mapholder.style.height='250px';
  mapholder.style.width='500px';
  
  console.log(lat)
  console.log(lon)
 
  var myOptions={
  center:latlon,zoom:14,
  mapTypeId:google.maps.MapTypeId.ROADMAP,
  mapTypeControl:false,
  navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
  };
  var map=new google.maps.Map(document.getElementById("mapholder"),myOptions);
  var marker=new google.maps.Marker({position:latlon,map:map,title:"Você está Aqui!"});
  }
 
