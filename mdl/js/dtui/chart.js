/**
 * Created by tuantmtb on 11/12/16.
 */
google.charts.load("current", {packages: ["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Xác suất thống kê', 11],
        ['Giải tích', 2],
        ['Đại số', 2],
        ['Cơ nhiệt', 2],
        ['Tín hiệu hệ thống', 7]
    ]);

    var options = {
        title: 'Thời gian hoạt động',
        pieHole: 0.4,
    };

    var chart = new google.visualization.PieChart(document.getElementById('timechart1'));
    chart.draw(data, options);
}


google.charts.setOnLoadCallback(drawChart2);

function drawChart2() {
    var data = google.visualization.arrayToDataTable([
        ['Ngày', 'Giải tích', 'Cơ nhiệt', 'Khác'],
        ['Thứ 2', 2, 1, 1],
        ['Thứ 3', 3, 0.5, 2],
        ['Thứ 4', 0, 2, 1],
        ['Hôm nay', 3, 2, 3]
    ]);

    var options = {
        title: 'Thời gian học hàng ngày',
        curveType: 'function',
        legend: {position: 'bottom'}
    };

    var chart = new google.visualization.LineChart(document.getElementById('time_analysis_chart'));

    chart.draw(data, options);
}


$(window).resize(function () {
    drawChart();
    drawChart2();

});

