$(document).ready(function () {

$.when(
    $.getScript( "/js/author/add.js" ),
    $.getScript( "/js/author/getAll.js" ),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function(){


});


});