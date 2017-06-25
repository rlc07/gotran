(function() {
  $(function() {
	  

	  var circle;
   var lat1 = $("#lat1").val();
   var lat2 = $("#lat2").val();
   var lat3 = $("#lat3").val();
   var lat4 = $("#lat4").val();
   var lat5 = $("#lat5").val();
   var lat6 = $("#lat6").val();
   
   var long1 = $("#long1").val();
   var long2 = $("#long2").val();
   var long3 = $("#long3").val();
   var long4 = $("#long4").val();
   var long5 = $("#long5").val();
   var long6 = $("#long6").val();
   
  
  
	
/*Script responsavel por retornar os circulo no mapa de acordo com cada lat long*/
   var startLoc1 = new google.maps.LatLng(lat1, long1);
   var startLoc2 = new google.maps.LatLng(lat2, long2);
   var startLoc3 = new google.maps.LatLng(lat3, long3);
   var startLoc4 = new google.maps.LatLng(lat4, long4);
   var startLoc5 = new google.maps.LatLng(lat5, long5);
   var startLoc6 = new google.maps.LatLng(lat6, long6);
	
    var circleDrawHandler, clearMarkers, earthRadii, map, markers, polygonDestructionHandler, searchBox, searchInput, updateURL;
    markers = [];
    map = new google.maps.Map($('#map')[0], {
      zoom: 14,
      center: new google.maps.LatLng(-22.831483770665564, -47.26249694824219),
      mapType: google.maps.MapTypeId.ROADMAP,
      

    });
    
	   google.maps.event.addListenerOnce(map, "idle", function() {
		      circle = new google.maps.Circle({
		          strokeColor: "#3DC371",
		          strokeOpacity: 0.8,
		          strokeWeight: 2,
		          fillColor: "#3DC371",
		          fillOpacity: 0.35,
		          map: map,
		          center: startLoc1,
		          radius: 1000,
		          clickable: true,
	    	        draggable: false,
	    	        editable: false,
	    	        
		        });
		      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);

				   circle = new google.maps.Circle({
		          strokeColor: "#3DC371",
		          strokeOpacity: 0.8,
		          strokeWeight: 2,
		          fillColor: "#3DC371",
		          fillOpacity: 0.35,
		          map: map,
		          center: startLoc2,
		          radius: 1000,
		          editable: false
		        });
				      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);
				      

				   circle = new google.maps.Circle({
		          strokeColor: "#3DC371",
		          strokeOpacity: 0.8,
		          strokeWeight: 2,
		          fillColor: "#3DC371",
		          fillOpacity: 0.35,
		          map: map,
		          center: startLoc3,
		          radius: 1000,
		          editable: false
		        });
				      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);
				      
			      circle = new google.maps.Circle({
			          strokeColor: "#3DC371",
			          strokeOpacity: 0.8,
			          strokeWeight: 2,
			          fillColor: "#3DC371",
			          fillOpacity: 0.35,
			          map: map,
			          center: startLoc4,
			          radius: 1000,
			          editable: false
			        });
					      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);
					      
				      circle = new google.maps.Circle({
				          strokeColor: "#3DC371",
				          strokeOpacity: 0.8,
				          strokeWeight: 2,
				          fillColor: "#3DC371",
				          fillOpacity: 0.35,
				          map: map,
				          center: startLoc5,
				          radius: 1000,
				          editable: false
				        });
					      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);
					 
					      circle = new google.maps.Circle({
					          strokeColor: "#3DC371",
					          strokeOpacity: 0.8,
					          strokeWeight: 2,
					          fillColor: "#3DC371",
					          fillOpacity: 0.35,
					          map: map,
					          center: startLoc6,
					          radius: 1000,
					          editable: false
					        });
							      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);


		    });

   
  
    earthRadii = {
      mi: 3963.1676,
      km: 6378.1,
      ft: 20925524.9,
      mt: 6378100,
      "in": 251106299,
      yd: 6975174.98,
      fa: 3487587.49,
      na: 3443.89849,
      ch: 317053.408,
      rd: 1268213.63,
      fr: 31705.3408,

    };

    polygonDestructionHandler = function() {

    	
    	
    	if(this.getCenter().lat() == lat1){
            lat1 = document.getElementById("lat1").value = "";
            document.getElementById("long1").value = "";
            document.getElementById("raio1").value = "";
            document.getElementById("mt1").value = "";

            this.setMap(null);

    	}else if(this.getCenter().lat() == lat2){
        	 lat2 = document.getElementById("lat2").value = "";
             document.getElementById("long2").value = "";
             document.getElementById("raio2").value = "";
             document.getElementById("mt2").value = "";

             this.setMap(null);

    	}else if(this.getCenter().lat() == lat3){
        	lat3 = document.getElementById("lat3").value = "";
            document.getElementById("long3").value = "";
            document.getElementById("raio3").value = "";
            document.getElementById("mt3").value = "";

            this.setMap(null);

    	}else if(this.getCenter().lat() == lat4){
        	lat4 = document.getElementById("lat4").value = "";
            document.getElementById("long4").value = "";
            document.getElementById("raio4").value = "";
            document.getElementById("mt4").value = "";

            this.setMap(null);

    	}else if(this.getCenter().lat() == lat5){
        	lat5 = document.getElementById("lat5").value = "";
            document.getElementById("long5").value = "";
            document.getElementById("raio5").value = "";
            document.getElementById("mt5").value = "";

            this.setMap(null);

    	}else if(this.getCenter().lat() == lat6){
        	lat6 = document.getElementById("lat6").value = "";
            document.getElementById("long6").value = "";
            document.getElementById("raio6").value = "";
            document.getElementById("mt6").value = "";

            this.setMap(null);

    	}
         
      

     

      	  
      
    };
    
    clearMarkers = function() {
      var i, len, m;
      for (i = 0, len = markers.length; i < len; i++) {
        m = markers[i];
        m.setMap(null);
        
      }

      return markers = [];
    };
    circleDrawHandler = function(e) {
      var radius, select, unitKey;
      select = $('#unitSelector');
      unitKey = $('option', select).eq(select[0].selectedIndex).val();
      radius = parseFloat(document.getElementById('radiusInput').value);
      radius = (radius / earthRadii[unitKey]) * earthRadii['mt'];
      
        
     
      
      var latLong = "";
   
      if(lat1 == ""){
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();
      lat1 = document.getElementById("lat1").value = latLong.lat();
      document.getElementById("long1").value = latLong.lng();
      document.getElementById("raio1").value = Math.round(circle.getRadius() / 1000)
      document.getElementById("mt1").value = Math.round(circle.getRadius() / 1)

      }
      else if(lat2 == ""){
    	  
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();
          lat2 = document.getElementById("lat2").value = latLong.lat();
          document.getElementById("long2").value = latLong.lng();
          document.getElementById("raio2").value = Math.round(circle.getRadius() / 1000)
          document.getElementById("mt2").value = Math.round(circle.getRadius() / 1)

      }
      else if(lat3 == ""){
    	  
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();

    	  lat3 = document.getElementById("lat3").value = latLong.lat();
          document.getElementById("long3").value = latLong.lng();
          document.getElementById("raio3").value = Math.round(circle.getRadius() / 1000)
          document.getElementById("mt3").value = Math.round(circle.getRadius() / 1)

      }else if(lat4 == ""){
    	  
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();

    	  lat4 = document.getElementById("lat4").value = latLong.lat();
          document.getElementById("long4").value = latLong.lng();
          document.getElementById("raio4").value = Math.round(circle.getRadius() / 1000)
          document.getElementById("mt4").value = Math.round(circle.getRadius() / 1)

      }else if(lat5 == ""){
    	  
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();

    	  lat5 = document.getElementById("lat5").value = latLong.lat();
          document.getElementById("long5").value = latLong.lng();
          document.getElementById("raio5").value = Math.round(circle.getRadius() / 1000)
          document.getElementById("mt5").value = Math.round(circle.getRadius() / 1)

      }    else if(lat6 == ""){
    	  
    	  circle = new google.maps.Circle({
    	        center: e.latLng,
    	        clickable: true,
    	        draggable: false,
    	        editable: false,
    	        fillColor: '#004de8',
    	        fillOpacity: 0.27,
    	        map: map,
    	        radius: radius,
    	        strokeColor: '#004de8',
    	        strokeOpacity: 0.62,
    	        strokeWeight: 1
    	      });
    	  
    	  latLong = circle.getCenter();

    	  lat6 = document.getElementById("lat6").value = latLong.lat();
          document.getElementById("long6").value = latLong.lng();
          document.getElementById("raio6").value = Math.round(circle.getRadius() / 1000)
          document.getElementById("mt6").value = Math.round(circle.getRadius() / 1)

      }else if(lat1 != "" && lat2 != "" && lat3 != "" && lat4 != "" && lat5 != "" && lat6 != ""){
    	     bootbox.alert({ 
			   size: "small",
			   title: "<b>GO</b>TRAN",
			   message: "<h4>Ops! e permitido somente 6 bairros por anuncio</h4>", 
			   callback: function(){ /* your callback code */ }
			 })
      }
      
    
       
      google.maps.event.addListener(circle, 'rightclick', polygonDestructionHandler);

      return google.maps.event.addListener(circle, 'click', circleDrawHandler);
    };
    google.maps.event.addListener(map, 'click', circleDrawHandler);
    searchInput = document.getElementById('searchInput');
    $(searchInput.form).on({
      submit: function() {
        return false;
      }
    });
    searchBox = new google.maps.places.SearchBox(searchInput);
    google.maps.event.addListener(searchBox, 'places_changed', function() {

      /* When a place is selected, center on it */
      var location;
      clearMarkers();
      location = searchBox.getPlaces()[0];
      if (location != null) {
        if (location.geometry.viewport != null) {
          map.fitBounds(location.geometry.viewport);
          map.panToBounds(location.geometry.viewport);
        } else {
          map.setCenter(location.geometry.location);
        }
        markers.push(new google.maps.Marker({
          position: location.geometry.location,
          map: map,
          title: location.name,
          clickable: false
          
        }));

      }
    });


  });

}).call(this);

//# sourceMappingURL=gmaps-radius.js.map

