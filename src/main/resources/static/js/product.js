$('document').ready(function() {
        $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(product, status){
        $('#idDetails').val(product.id);
        $('#ddlCategoryDetails').val(product.categoryid);
        $('#nameDetails').val(product.name);
        $('#prixDetails').val(product.prix);
        $('#lastModifiedByDetails').val(product.lastModifiedBy);
        $('#lastModifiedDateDetails').val(product.lastModifiedDate.substr(0,19).replace("T", " "));
        $('#createdByDetails').val(product.createdBy);
        $('#createdDateDetails').val(product.createdDate.substr(0,19).replace("T", " "));
    });
        $('#detailsModal').modal('show');
    });
$('table #editButton').on('click',function(event){
    event.preventDefault();
    var href= $(this).attr('href');
    $.get(href, function(product, status){
        $('#idEdit').val(product.id);
        $('#ddlCategoryEdit').val(product.categoryid);
        $('#nameEdit').val(product.name);
        $('#prixEdit').val(product.prix);
    });
    $('#editModal').modal('show');
});

    $('table #deleteButton').on('click',function(event) {
    event.preventDefault();
    var href = $(this).attr('href');
    $('#deleteConfirmButton').attr('href', href);
    $('#deleteModal').modal('show');
});
});