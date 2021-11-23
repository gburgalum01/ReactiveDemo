//This function makes an AJAX request to the server which will trigger the server to send the
//notification to the specified user.
function sendNotification() {

	$.ajax({
        url: '/sendnotification',
		type: "POST",
        contentType: 'application/json',
        dataType: "json",
		data: JSON.stringify({
		    "USER": $('#user').val(),
		    "NOTIFICATION": $('#notification').val()
		}),
		success: function(pcdata){
            console.log("Notification sent.");
        },
        error: function (xhr, status, error) {
            console.log("Notification not sent. Error: " + error);
   		}
	});
}