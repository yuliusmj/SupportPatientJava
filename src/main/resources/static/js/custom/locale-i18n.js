$(document).ready(function() {

    $('#locales').on('click', 'a.i18n', function(e) {
        var parameterModel = $(this).data('lang');

        window.location.replace(window.location.href + '?lang=' + parameterModel);        
    });
});