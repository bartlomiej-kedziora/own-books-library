
if (window.location.href.indexOf("authors") != -1 || /authors\/\d+$/.test(window.location.href)) {
        if (document.referrer.indexOf("books") != -1) {
            url = window.location.href;
            id = Number(url.substring(url.lastIndexOf('/') + 1));
            if(isNaN(id)) {
                var urlType = "authors/details";
            } else {
                var urlType = "authors/" + id + "/book";
            }
        }
        else {
            var urlType = "authors/details";
        }
        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-task-id', data.id);
            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-name-section] [data-task-name-paragraph]').text(data.name);
            element.find('[data-task-content-section] [data-task-content-paragraph]').text(data.surname);
            element.find('[data-task-country-section] [data-task-country-paragraph]').text(data.country);
            element.find('[data-task-city-section] [data-task-city-paragraph]').text(data.city);
            element.find('[data-task-birth-section] [data-task-birth-paragraph]').text(data.yearOfBirth);
            element.find('[data-task-books-section]').click(function () {
                linkRender(
                    "books/" + data.id + "/author",
                    "/books/" + data.id
                )
            });
            element.find('[data-task-edit-button]').click(function () {
                window.location.href = "author?edit";
            });
            return element;
        }

        getAll(urlType);
        $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
}