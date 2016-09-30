var Contact = function () {

    return {
        //main function to initiate the module
        init: function () {
			var map;
			$(document).ready(function(){
			  map = new GMaps({
				div: '#gmapbg',
				lat: 21.0384376,
				lng: 105.7817945
			  });
			   var marker = map.addMarker({
		          lat: 21.0384376,
				lng: 105.7817945,
		            title: 'UET-VNU.',
		            infoWindow: {
		                content: "Trường Đại học Công Nghệ <br> Đại học Quốc gia Hà Nội"
		            }
		        });

			   marker.infoWindow.open(map, marker);
			});
        }
    };

}();

jQuery(document).ready(function() {    
   Contact.init(); 
});

