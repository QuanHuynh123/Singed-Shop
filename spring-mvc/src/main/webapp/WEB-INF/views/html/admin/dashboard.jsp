<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
    <title>SINGED-SHOP</title>
    <!-- Bạn cần thêm link đến thư viện Chart.js -->
    
    <link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <script src="<c:url value='https://cdn.jsdelivr.net/npm/chart.js'/>"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value='/static/javascript/sweetalert2.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/static/css/sweetalert2.min.css'/>">
</head>
<body>


    <div id="content" style="background-color: white">
        <div style="width: 100%; margin-top: 50px;">
            <canvas id="revenueChart"></canvas>
        </div>
    </div>
    </div>

    <script>
    document.addEventListener('DOMContentLoaded', function () {
        fetch('http://localhost:8080/spring-mvc/api/dashboard')
            .then(response => response.json())
            .then(data => {
                var monthLabels = data.map(item => item.Month);
                var revenueData = data.map(item => item.Scale);

                var ctx = document.getElementById('revenueChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: monthLabels,
                        datasets: [{
                            label: 'Tăng giảm doanh thu',
                            data: revenueData,
                            borderColor: 'rgba(75, 192, 192, 1)',
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderWidth: 1,
                            fill: true
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                                max: 100
                            }
                        }
                    }
                });
            })
            .catch(console.error('Error:', error));
    });

    </script>
</body>
</html>