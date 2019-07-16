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

        getAll(urlType);
        $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
        $('[data-task-add-form]').on('submit', {urlType: urlType}, handleFormOrLangSubmitRequest);
    }