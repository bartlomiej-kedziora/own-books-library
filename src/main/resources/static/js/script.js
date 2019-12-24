$(document).ready(function () {

$.when(
    $.getScript( "/js/default.js" ),
    $.getScript( "/js/author/scripts.js" ),
    $.getScript( "/js/book/getAll.js" ),
    $.getScript( "/js/collection/getAll.js" ),
    $.getScript( "/js/form/getAll.js" ),
    $.getScript( "/js/lang/getAll.js" ),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function(){


});


});
