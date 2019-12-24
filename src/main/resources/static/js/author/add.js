$('[data-task-add-form]').on('submit', {urlType: "authors"}, handleAuthorSubmitRequest);

function handleAuthorSubmitRequest(event) {
    event.preventDefault();

    var author = JSON.stringify({
        name: $(this).find('[name="name"]').val(),
        surname: $(this).find('[name="surname"]').val(),
        country: $(this).find('[name="country"]').val(),
        city: $(this).find('[name="city"]').val(),
        yearOfBirth: $(this).find('[name="birth"]').val(),
    });

//    var author = new Array();
//    author['name'] = $(this).find('[name="name"]').val();
//    author['surname'] = $(this).find('[name="surname"]').val();
//    author['country'] = $(this).find('[name="country"]').val();
//    author['city'] = $(this).find('[name="city"]').val();
//    author['yearOfBirth'] = $(this).find('[name="birth"]').val();

    var bookIds = new Array($(this).find('[name="books[]"]').val());
    alert("ksiazki: " + bookIds);
    if(bookIds.length > 0) {
        bookIds.forEach(id => {
            var book = getBookById("books/" + id);
            console.log(var_dump(book));
            var values = JSON.stringify({
                authors : [author],
                id: book.id,
                genre: book.genre,
                series: book.series,
                title: book.title,
                titleEng: book.titleEng,
                year: book.year
            });
            alert(values);
            justPost(event, values, "/authors");
        });
    } else {
        alert(values);
        justPost(event, author, "/authors");
    }

    window.location.href = "/authors";
}

function getBookById(urlType) {
    const requestUrl = apiRoot + urlType;
    var status = false;

    $.ajax({
        url: requestUrl,
        method: 'GET',
        contentType: "application/json",
        async: false,
        success: function (tasks) {
            result = tasks;
        },
        error: function() {
//            status = false;
        }
    });
    return result;
}

