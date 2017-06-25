var markers = [], map, clearMarkers, searchInput;
            function initialize() {
                var latitude = -22.7836726,
                    longitude = -47.29450859999997,
                    radius = 899999999999999999999999999999998000, //how is this set up
                    center = new google.maps.LatLng(latitude,longitude),
                    bounds = new google.maps.Circle({center: center, radius: radius}).getBounds(),
                    mapOptions = {
                        center: center,
                        zoom: 9,
                        mapTypeId: google.maps.MapTypeId.ROADMAP,
                        scrollwheel: false
                    };
             map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

                setMarkers(center, radius, map);
            }

            function setMarkers(center, radius, map) {
                var json = (function () { 
                    var json = null; 
                    $.ajax({ 
                        'async': false, 
                        'global': false, 
                        'url': "/gotran/jsonRelatorio.jsp", 
                        'dataType': "json", 
                        'success': function (data) {
                             json = data; 
                         }
                    });
                    return json;
                })();

                var circle = new google.maps.Circle({
                        strokeColor: '#000000',
                        strokeOpacity: 0.25,
                        strokeWeight: 1.0,
                        fillColor: '#ffffff',
                        fillOpacity: 0.1,
                        clickable: false,
                        map: map,
                        center: center,
                        radius: radius
                    });
                var bounds = circle.getBounds();

                //loop between each of the json elements
                for (var i = 0, length = json.length; i < length; i++) {
                    var data = json[i],
                    latLng = new google.maps.LatLng(data.latitude, data.longitude); 

                    var qtd = "5 pessoas pesquizaram"

                    if(bounds.contains(latLng)) {
                        // Creating a marker and putting it on the map
                        var marker = new google.maps.Marker({
                            position: latLng,
                            map: map,
                            title: data.descricao
                       
                        });
                        infoBox(map, marker, data);
                    }
                }

                circle.bindTo('center', marker, 'position');
            }

            function infoBox(map, marker, data) {
                var infoWindow = new google.maps.InfoWindow();
                // Attaching a click event to the current marker
                google.maps.event.addListener(marker, "click", function(e) {
                    infoWindow.setContent(data.descricao);
                    infoWindow.open(map, marker);
                });

                // Creating a closure to retain the correct data 
                // Note how I pass the current data in the loop into the closure (marker, data)
                (function(marker, data) {
                  // Attaching a click event to the current marker
                  google.maps.event.addListener(marker, "click", function(e) {
                    infoWindow.setContent(data.descricao);
                    infoWindow.open(map, marker);
                  });
                })(marker, data);
            }

            
            clearMarkers = function() {
                var i, len, m;
                for (i = 0, len = markers.length; i < len; i++) {
                  m = markers[i];
                  m.setMap(null);
                  
                }

                return markers = [];
              };
              
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
           google.maps.event.addDomListener(window, 'load', initialize);