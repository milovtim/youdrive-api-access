$(function () {
    var $carList = $('#carList');
    $('#loginBlock').on('click', "input:button", function (e) {
        $.get('/api/login')
            .done(function () {
                $(e.delegateTarget).find('.api-login-result').text('logged in');
            })
            .fail(function (e) {
                $(e.delegateTarget).find('.api-login-result').text('Failed login: '+ e.message);
            });
    });

    $carList.on('click', 'input:button', function () {
        var ajaxSettings = {
            url: '/car/all',
            dataType: 'json'
        };
        if (('youdrive' in window) && ('map' in youdrive)) {
            var center = youdrive.map.getCenter();
            ajaxSettings.data = {'lat': center.lat(), 'lng': center.lng()};
        }
        $.ajax(ajaxSettings)
            .done(function (data) {
                if (!(data && $.isArray(data))) {
                    return;
                }
                var list = $carList.find('.car-list'); list.empty();
                youdrive.clearMarkers();
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
                    addCarToMap(car);
                });
            }).fail(function (data, status) {
        });
    });

    function addCarToMap(car) {
        var data = '<p>' + car.model + '<br/>' + car.gosNumber + '</p>';
        youdrive.addMarker(car.coord.lat, car.coord.lng, data);
    }

    $carList
        .children('.car-list').on('click', '.carLink', function (e) {
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
            });
        });

    $('#geoLocate').on('click', 'input:button', function (e) {
        window.youdrive.myPosition();
    });
});

