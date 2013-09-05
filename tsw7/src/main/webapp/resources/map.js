   	
function updateAddress(address) {
	alert("in map.js updateAddress");
	geocoder.getLatLng(address, function(location) {
		map_canvas.setCenter(location, 13);
		var marker = new google.maps.Marker(location);
		map_canvas.addOverlay(marker);
		marker.openInfoWindowHtml(getAddressInfo(address));
		
		latField.value = location.lat();
		lngField.value = location.lng();
	});
}

function getAddressInfo(address) {
	return address + "<br><a href=\"http://www.teamsportsware.com\">Powered by Team Sportsware</a>";
}
