$(document).ready(function () {


    /* initialize the external events
     -----------------------------------------------------------------*/
    $('#external-events .fc-event').each(function () {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true, // maintain when user navigates (see docs on the renderEvent method)
            color: '#00bcd4'
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });


    /* initialize the calendar
     -----------------------------------------------------------------*/
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
        },
        defaultDate: '2016-11-01',
        editable: true,
        droppable: true, // this allows things to be dropped onto the calendar
        eventLimit: true, // allow "more" link when too many events
        events: [
            {
                title: 'Trình bày DTUI',
                start: '2016-10-30',
                color: '#9c27b0'
            },
            {
                title: 'Kiểm tra tín hiệu hệ thống',
                start: '2016-11-01',
                color: '#e91e63'
            },
            {
                id: 999,
                title: 'Ôn XSTK',
                start: '2016-11-02',
                end: '2016-11-05',
                color: '#ff1744'
            },
            {
                id: 999,
                title: 'Mang vở ghi kiểm tra',
                start: '2016-11-03',
                color: '#aa00ff'
            },
            {
                title: 'Học thuộc',
                start: '2016-11-10',
                end: '2016-11-15',
                color: '#01579b'
            }, {
                title: 'BTL CSDL',
                start: '2016-11-16',
                end: '2016-11-19',
                color: '#01579b'
            },
            {
                title: 'Họp nhóm web',
                start: '2016-11-21',
                color: '#2196f3'
            },
            {
                title: 'Thi thể dục',
                start: '2016-11-30',
                color: '#ff5722'
            }
        ]
    });

});