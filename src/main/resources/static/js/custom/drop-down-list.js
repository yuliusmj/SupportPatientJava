$(document).ready(function () {
    $("#countryId").change(function () {
        getZones($(this).val());
    });
});

function getZones(countryId) {
    $('.block').css('display', 'flex');
    $("#zoneId").empty();
    $("#zoneId").append('<option value="0">Seleccione una opción</option>');
    $.ajax({
        type: "POST",
        url: '/departments/getZonesByCountryId',
        dataType: 'json',
        data: {countryId: countryId},
        success: function (data) {
            $.each(data, function (i, data) {
                $("#zoneId").append('<option value="'
                    + data.id + '">'
                    + data.description + '</option>');
            });
            $('.block').css('display', 'none');
        },
        error: function (ex) {
            swal("Error", 'Fallo al cargar las opciones.' + ex.statusText, "error");
        }
    });
}