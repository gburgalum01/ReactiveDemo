//This function sets up the EventSource to consume events from the server at the given
//web address.  Note that the selected user is sent in the URL so that only the events
//destined for the user will be received.
function viewUserNotifications() {

    resetView();
    var user = $('#user').val();

    var source = new EventSource("/viewnotifications/" + user);
    source.addEventListener('message', function (e) {
        var body = JSON.parse(e.data);
        addNotificationRow(body);
    }, false);

    $('#userNotificationsTable').show();
    $('#noNotificationsReceived').show();
}

//This function adds a row to the notifications table when a notification event has been received from the server.
function addNotificationRow(eventData) {

    var notificationRow = document.createElement('tr');

    var notificationColumn = document.createElement('td');
    notificationColumn.innerHTML = eventData.NOTIFICATION;

    notificationRow.append(notificationColumn);

    $('#noNotificationsReceived').hide();
    $('#notificationRows').append(notificationRow);
}

//This function resets the events view by clearing the event rows and then hiding the events table.
function resetView() {
    $('#notificationRows').find('tr').remove();
    $('#userNotificationsTable').hide();
}