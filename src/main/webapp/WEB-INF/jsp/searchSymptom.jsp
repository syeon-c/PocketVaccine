<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/chartjs/Chart.js"/>"></script>
<style>
canvas{
    -moz-user-select: none;
    -webkit-user-select: none;
    -ms-user-select: none;
}
</style>

<body>
 <div style="width:80%">
        <div>
            <canvas id="canvas" height="350" width="600"></canvas>
        </div>
    </div>
<script>
var chartLabels = [];
var chartData1 = [];

$.getJSON("http://localhost:8080/home?tab=data", function(data) {

			$.each(data, function(inx, obj) {
				chartLabels.push(obj.userAge)
				chartData.push(obj.board_symptom);
			});

			createChart();

			console.log("create Chart")

		});

var lineChartData = {
    labels : chartLabels,
    datasets : [
        {
            label: "백신 접종 후 대표 증상",
            fillColor : "rgba(220,220,220,0.2)",
            strokeColor : "rgba(220,220,220,1)",
            pointColor : "rgba(220,220,220,1)",
            pointStrokeColor : "#fff",
            pointHighlightFill : "#fff",
            pointHighlightStroke : "rgba(220,220,220,1)",
            data : chartData1 ,
            backgroundColor: [
                "#FF6384",
                "#4BC0C0",
                "#FFCE56",
                "#E7E9ED",
                "#36A2EB"
            ]
        }
    ]

}

function createChart(){
    var ctx = document.getElementById("canvas").getContext("2d");
    new Chart(ctx, {
        type: 'horizontalBar',
        data: lineChartData,
        options: {
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            }
        }
    });
}

</script>
</body>
</html>


