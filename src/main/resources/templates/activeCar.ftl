<#-- @ftlvariable name="car" type="youdrive.today.models.Car" -->
<!DOCTYPE HTML>
<html>
<head>
    <meta content="text/html" charset="utf-8" http-equiv="Content-Type">
    <title>Car </title>
    <script src="/webjars/jquery/3.0.0/jquery.min.js" type="text/javascript"></script>
</head>
<body>
    <div>
        <div id="carData">
        <#if car??>
            <p>Color: ${car.color}</p>
            <p>Gos number: ${car.number}</p>
            <p>Fuel: ${car.fuel}%</p>
            <p>Coords: ${car.lat},${car.lon}</p>
            <p>
                <img src="${car.img}">
            </p>
        <#else >
            no cars found
        </#if>
        </div>
        <div id="mngmnt">
            <h3>Management:</h3>
            <p><input type="button" value="Reserve" id="reserveCar"/></p>
            <p><input type="button" value="Open" id="openCar"/></p>
            <p><input type="button" value="Close" id="closeCar"/></p>
            <p><input type="button" value="End reserve" id="endReserve"/></p>
            <p></p>
        </div>
    </div>
    <div><a href="/cars"><< Back <<</a></div>

<script type="text/javascript">
    $(function () {
        var $resultBlock = $('#mngmnt').children('p:last');

        $('#reserveCar').click(function (e) {
            $.ajax({
                url: '/car/active/reserve',
                method: 'POST',
                processData: false
            }).done(function () {
                $resultBlock.text('reserved');
            })
        });

        $('#openCar').click(function () {
            $.ajax({
                url: '/car/active/reserve/open',
                method: 'PUT',
                processData: false
            }).done(function () {
                $resultBlock.text('opened');
            })
        });

        $('#closeCar').click(function () {
            $.ajax({
                url: '/car/active/reserve/close',
                method: 'PUT',
                processData: false
            }).done(function () {
                $resultBlock.text('closed');
            })
        });

        $('#endReserve').click(function () {
            $.ajax({
                url: '/car/active/reserve',
                method: 'DELETE',
                processData: false
            }).done(function () {
                $resultBlock.text('End reserve');
            })
        });

    });
</script>
</body>
</html>