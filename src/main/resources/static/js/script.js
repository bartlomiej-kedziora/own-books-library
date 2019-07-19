$(document).ready(function () {

    const apiRoot = 'http://localhost:8080/v1/';
    const datatableRowTemplate = $('[data-datatable-row-template]');//.children()[0];
    const $tasksContainer = $('[data-tasks-container]');

    // init
    if (window.location.href.indexOf("authors") != -1) {
        var urlType = "authors";
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
            });

            return element;
        }
    }
    if (window.location.href.indexOf("books") != -1) {
        var urlType = "books";
        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-task-id', data.id);
            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-titlePL-section] [data-task-titlePL-paragraph]').text(data.titlePl);
            element.find('[data-task-titleEN-section] [data-task-titleEN-paragraph]').text(data.titleEn);
            element.find('[data-task-series-section] [data-task-series-paragraph]').text(data.series);
            element.find('[data-task-genre-section] [data-task-genre-paragraph]').text(data.genre);
            element.find('[data-task-year-section] [data-task-year-paragraph]').text(data.year);
            element.find('[data-task-authors-section]').click(function () {
            });

            return element;
        }
    }
    if (window.location.href.indexOf("forms") != -1) {
        var urlType = "forms";
        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-task-id', data.id);
            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-title-section] [data-task-title-paragraph]').text(data.value);
            element.find('[data-task-edit-section]').click(function () {
            });

            return element;
        };

        $('[data-task-add-form]').on('submit', {urlType: urlType}, handleFormOrLangSubmitRequest);
    }
    if (window.location.href.indexOf("langs") != -1) {
        var urlType = "langs";
        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-task-id', data.id);
            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-title-section] [data-task-title-paragraph]').text(data.value);
            element.find('[data-task-edit-section]').click(function () {
            });

            return element;
        };

        $('[data-task-add-form]').on('submit', {urlType: urlType}, handleFormOrLangSubmitRequest);
    }

        function getAll(urlType) {
            $tasksContainer.empty();
            const requestUrl = apiRoot + urlType;

            $.ajax({
                url: requestUrl,
                method: 'GET',
                contentType: "application/json",
                success: function (tasks) {
                    counter = 0;
                    tasks.forEach(task => {
                        //availableTasks[task.id] = task;
                        createData(task, ++counter).appendTo($tasksContainer);
                    console.log(task);
                })
                    ;
                }
            });
        }

    function handleFormOrLangSubmitRequest(event) {
        event.preventDefault();

        var formTitle = $(this).find('[name="title"]').val();

        var requestUrl = apiRoot + event.data.urlType;
        $.ajax({
            url: requestUrl,
            method: 'POST',
            processData: false,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: JSON.stringify({
                value: formTitle
            }),
            complete: function(data) {
                if(data.status === 200) {
                    getAll(urlType);
                }
            }
        });
    }

    function handleDeleteRequest(event) {
        var parentEl = $(this).parents('[data-task-id]');
        var taskId = parentEl.attr('data-task-id');
        var requestUrl = apiRoot + event.data.urlType;

        $.ajax({
            url: requestUrl + '/' + taskId,
            method: 'DELETE',
            success: function() {
                parentEl.slideUp(400, function() { parentEl.remove(); });
            }
        })
    }

    getAll(urlType);
    $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
});
