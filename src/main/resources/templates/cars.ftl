<!DOCTYPE HTML>
<html>
<head>
    <meta content="text/html" charset="utf-8" http-equiv="Content-Type">
    <title>Cars</title>
    <script src="/webjars/jquery/3.0.0/jquery.min.js" type="text/javascript"></script>
</head>
<body>

    <div id="loginBlock">
        <div><input type="button" value="api login"></div>
        <div class="api-login-result"></div>
    </div>
    <div id="carList">
        <div><input type="button" value="update list"></div>
        <div class="car-list"></div>
    </div>

    <div>
        <p id="position"></p>
    </div>
    <div id="log"></div>

    <script type="text/javascript">
$(function () {
    var $carList = $('#carList');
    coords = null;

    toggleWatch();

    $('#loginBlock').on('click', "input:button", function (e) {
        $.get('/api/login').done(function () {
            $(e.delegateTarget).find('.api-login-result').text('logged in');
        })
    });

    $carList.on('click', 'input:button', function () {
        loadCarList($carList);
    });

    $carList.children('.car-list').on('click', '.carLink', function (e) {
        e.preventDefault();
        var car = $(this).data('car');
        if (!car) return;

        $.ajax({
            url: '/car/active',
            method: 'POST',
            data: JSON.stringify(car),
            contentType: 'application/json',
            processData: false
        }).done(function () {
            window.location.href = '/car'
        })
    });
});

    function handlePosition(pos) {
        $('#position').text(pos.coords.latitude + ',' +pos.coords.longitude + '(update: ' + new Date() + ')');
        coords = pos.coords;
    }
    function toggleWatch() {
        if (navigator.geolocation) {
            navigator.geolocation.watchPosition(handlePosition)
        }
    }

    function loadCarList($listBlock) {
        var ajaxSettings = {
            url: '/car/all',
            dataType: 'json'
        };
        if (coords) {
            ajaxSettings.data = {'lat': coords.latitude, 'lng': coords.longitude};
        }
        $.ajax(ajaxSettings)
            .done(function (data) {
                if (data && $.isArray(data)) {
                    var list = $listBlock.find('.car-list'); list.empty();
                    var $carLink = $('<a/>', {href: '#', 'class': 'carLink'});
                    var $mapLink = $('<a/>', {text: 'on map'});
                    $.each(data, function (idx, car) {
                        var latlng = car.coord;
                        var carLink = $carLink.clone()
                                .text(car.model + ':' + car.gosNumber)
                                .data('car', car);
                        if (car.active)
                            carLink.css('color', 'red');
                        var geoLink = $mapLink.clone()
                                .attr('href', 'geo:' + latlng.lat + ',' + latlng.lng);
                        $('<p>').append(carLink)
                                .append(' (dist: ' + car.distanceToCar + ')')
                                .append(geoLink)
                                .appendTo(list);
                    })
                }
            }).fail(function (data, status) {
                $('#log').text(status)
            })
    }
    </script>
</body>
</html>