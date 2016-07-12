<!DOCTYPE HTML>
<html>
<head>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="text/html" charset="utf-8" http-equiv="Content-Type" />
    <title>Cars</title>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js" integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s=" crossorigin="anonymous"></script>
</head>
<body>

    <div id="loginBlock">
        <div><input type="button" value="api login"></div>
        <div class="api-login-result"></div>
    </div>
    <div id="maps" style="width: 90%; height: 300px; margin-left: auto; margin-right: auto;"></div>
    <div id="geoLocate">
        <input type="button" value="My position" />
    </div>
    <div id="carList">
        <div><input type="button" value="update list"></div>
        <div class="car-list"></div>
    </div>

    <script type="text/javascript" src="/js/main.js"></script>
    <script type="text/javascript" src="/js/bundle.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyQyzOCWplF3wamCvMXE1DKmAVE_O0BgA&callback=youdrive.initMap" async defer></script>

</body>
</html>