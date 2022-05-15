$('document').ready(function() {
$('table #editButton').on('click',function(event){
    event.preventDefault();
    var href= $(this).attr('href');
    $.get(href, function(user, status){
        $('#idEdit').val(user.id);
        $('#firstnameEdit').val(user.firstname);
        $('#lastnameEdit').val(user.lastname);
        $('#usernameEdit').val(user.username);
        $('#phoneEdit').val(user.phone);
        $('#emailEdit').val(user.email);
        $('#passwordEdit').val(user.password);
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