<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<script type = "text/javascript" src = "https://www.gstatic.com/charts/loader.js">
</script>

<script type = "text/javascript">
    google.charts.load('current', {packages: ['corechart']});
</script>


<div id = "container" style = "width: 550px; height: 400px; margin: 0 auto">
</div>
<script language = "JavaScript">
    function drawChart() {
        // Define the chart to be drawn.
        var data = google.visualization.arrayToDataTable([
            ['Date', 'Temp'],
            ['2013',  1000 ],
            ['2014',  1170],
            ['2015',  660],
            ['2016',  1030]
        ]);

        var options = {title: 'Company Performance',
            hAxis: {title: 'Year', titleTextStyle: {color: '#333'}},
            vAxis: {minValue: 0}
        };

        // Instantiate and draw the chart.
        var chart = new google.visualization.AreaChart(document.getElementById ('container'));
        chart.draw(data, options);
    }
    google.charts.setOnLoadCallback(drawChart);
</script>

<jsp:include page="footer.jsp"/>

