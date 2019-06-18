var Table;

$(document).ready(function () {

    Table = $('#myDatatable').DataTable({
        responsive: true,
        "language": {
            "url": "/js/custom/datatables/Spanish.json",
            buttons: {
                pageLength: {
                    _: "%d",
                    '-1': "Ver Todos"
                }
            },
            search: ' ',
            searchPlaceholder: "Buscar..."
        },
        lengthMenu: [
            [5, 10, 25, 50, -1],
            ['5', '10', '25', '50', 'Ver Todos']
        ],
        dom: 'Bfrtip',
        stateSave: false,
        buttons: [
            'pageLength'
        ],
    });//Fin table
});