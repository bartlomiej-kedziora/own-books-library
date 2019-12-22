const apiRoot = 'http://localhost:8080/v1/';
    const datatableRowTemplate = $('[data-datatable-row-template]');//.children()[0];
    const $tasksContainer = $('[data-tasks-container]');

function var_dump(object) {
    return JSON.stringify(object);
}

// ADD SECTION
    if (window.location.href.search("author$") != -1) {
        var urlType = "books";
        function getBooks(urlType) {
            const requestUrl = apiRoot + urlType;

            $.ajax({
                url: requestUrl,
                method: 'GET',
                contentType: "application/json",
                success: function (tasks) {
                    counter = 0;
                    prepareBooksSelectOptions(tasks).appendTo($tasksContainer);
                },
                // error: function() {
                //     alert("Item not found!");
                //     window.location.href = document.referrer;
                // }
            });
        }

        function prepareBooksSelectOptions(tasks) {
            const element = $(datatableRowTemplate).clone();
            var counter = 0;
                tasks.forEach(task => {
                    element.find('[data-list-name-select]').append(prepareBookOption(++counter,task))});

            element.find('[data-task-add-button]').click(function () {
                alert("ok")});
            if(element.find('[data-list-name-select]').is(':selected')) {
                alert("wybrany")
            }
            console.log(element);
            return element;
        }

        function prepareBookOption(counter, task) {

                return $('<option>')
                    .addClass('crud-select__option')
                    .val(task.id)
                    .text(counter + ". " + task.title + " | " + (task.titleEng || 'Unknown name') + " | " + task.series + " | " + task.genre + " | " + task.year)
        }

        function handleTaskUpdateRequest() {
            var parentEl = $(this).parents('[data-task-id]');
            var taskId = parentEl.attr('data-task-id');
            var taskTitle = parentEl.find('[data-task-name-input]').val();
            var taskContent = parentEl.find('[data-task-content-input]').val();
            var requestUrl = apiRoot;

            $.ajax({
                url: requestUrl,
                method: "PUT",
                processData: false,
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: JSON.stringify({
                    id: taskId,
                    yearOfBirth: taskTitle,
                    name: taskContent,
                    surname: taskContent,
                    city: taskContent,
                    country: taskContent,
                    books: taskContent

                }),
                success: function(data) {
                    parentEl.attr('data-task-id', data.id).toggleClass('datatable__row--editing');
                    parentEl.find('[data-task-name-paragraph]').text(taskTitle);
                    parentEl.find('[data-task-content-paragraph]').text(taskContent);
                }
            });
        }


        getBooks(urlType);
    }
    // END ADD SECTION
        function getAll(urlType) {
            $tasksContainer.empty();
            const requestUrl = apiRoot + urlType;
//            alert(requestUrl);

            $.ajax({
                url: requestUrl,
                method: 'GET',
                contentType: "application/json",
                success: function (result) {
                if(!(result instanceof Array)) {
                    result = new Array(result);
                }
                console.log("DANE: " + var_dump(result));
                    counter = 0;
                    result.forEach(data => {
                        //availableTasks[task.id] = task;
                        var obj = createData(data, ++counter);
                            $.each(obj, function(k,v) {
                                if(isNaN(k) && k.indexOf('key') !== -1) {
                                    v.appendTo($tasksContainer);
                                } else {
                                    obj.appendTo($tasksContainer)
                                }
                            })
                    })
                }
                // error: function() {
                //     alert("Item not found!");
                //     window.location.href = document.referrer;
                // }
            });
        }

    function isData(urlType) {
        const requestUrl = apiRoot + urlType;
        var status = false;

        $.ajax({
            url: requestUrl,
            method: 'GET',
            contentType: "application/json",
            async: false,
            success: function (tasks) {
                status = tasks.length > 0;
            },
            error: function() {
                status = false;
            }
        });
        return status;
    }

    function linkRender(ajaxUrl, hrefUrl) {
        if(isData(ajaxUrl)) {
            window.location.href = hrefUrl;
        }
        else {
            alert("No items found!");
        }
    }

    function addToCollection(bookId) {
        //event.preventDefault();
        var book = getBookById(bookId);
        console.log(var_dump(book));
        var requestUrl = apiRoot + "items-collection";
        $.ajax({
            url: requestUrl,
            method: 'POST',
            processData: false,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: JSON.stringify({
                book: book
            }),
            complete: function(data) {
                if(data.status === 200) {
                    alert("Item added to collection");
                }
            }
        });
    }

    function getBookById(bookId) {
        const requestUrl = apiRoot + "books/" + bookId;
                var result;

                $.ajax({
                    url: requestUrl,
                    method: 'GET',
                    contentType: "application/json",
                    async: false,
                    success: function (data) {
                        result = data;
                    },
                    error: function() {
                        result = false;
                    }
                });
                return result;
    }

    function removeFromCollection(bookId) {
        var collectionItem = getCollectionItemByBookId(bookId);
                console.log(var_dump(collectionItem));
                var requestUrl = apiRoot + "items-collection/" + collectionItem.id;
                $.ajax({
                    url: requestUrl,
                    method: 'DELETE',
                    processData: false,
                    complete: function(data) {
                        if(data.status === 200) {
                            alert("Item removed from collection");
                        }
                    }
                });
    }

    function getCollectionItemByBookId(bookId) {
        const requestUrl = apiRoot + "items-collection/" + bookId + "/book";
                        var result;

                        $.ajax({
                            url: requestUrl,
                            method: 'GET',
                            contentType: "application/json",
                            async: false,
                            success: function (data) {
                                result = data;
                            },
                            error: function() {
                                result = false;
                            }
                        });
                        return result;
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