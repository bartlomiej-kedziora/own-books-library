if (window.location.href.indexOf("books") != -1 || /books\/\d+$/.test(window.location.href)) {
        if (document.referrer.indexOf("authors") != -1) {
            url = window.location.href;
            id = Number(url.substring(url.lastIndexOf('/') + 1));
            if(isNaN(id)) {
                var urlType = "books";
            } else {
                var urlType = "books/" + id + "/author";
            }
        }
        else {
            var urlType = "books";
        }

        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-book-id', data.id);
            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-title-section] [data-task-title-paragraph]').text(data.title);
            element.find('[data-task-titleENG-section] [data-task-titleENG-paragraph]').text(data.titleEng);
            element.find('[data-task-series-section] [data-task-series-paragraph]').text(data.series);
            element.find('[data-task-genre-section] [data-task-genre-paragraph]').text(data.genre);
            element.find('[data-task-year-section] [data-task-year-paragraph]').text(data.year);
            element.find('[data-task-authors-section]').click(function () {
                linkRender(
                    "authors/" + data.id + "/book",
                    "/authors/" + data.id
                )
            });
            element.find('[data-task-addtocollection-section]').click(function () {
                addToCollection(data.id);
            });
            element.find('[data-task-removefromcollection-section]').click(function () {
                removeFromCollection(data.id);
            });
            console.log(element);
            return element;
        }

        getAll(urlType);
        $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
}