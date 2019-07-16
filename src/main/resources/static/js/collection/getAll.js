if (window.location.href.indexOf("collections") != -1) {
        var urlType = "collections/user";
        const forms = {
            EBOOK: '/img/ebook.png',
            PAPER: '/img/book.png'
        }
        function createData(data, counter) {
            const element = $(datatableRowTemplate).clone();

            element.attr('data-task-id', data.id);
//            element.find('[data-task-series] [data-task-series-paragraph]').text(data.homeCollectionItems[counter-1].book.series);

            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter);
            element.find('[data-task-year-section] [data-task-year-paragraph]').text(data.homeCollectionItems[counter-1].book.year);
            element.find('[data-task-title-section] [data-task-title-paragraph]').text(data.homeCollectionItems[counter-1].book.title);
            element.find('[data-task-titleENG-section] [data-task-titleENG-paragraph]').text(data.homeCollectionItems[counter-1].book.titleEng);
            element.find('[data-task-genre-section] [data-task-genre-paragraph]').text(data.homeCollectionItems[counter-1].book.genre);
            element.find('[data-task-worldscore-section] [data-task-worldscore-paragraph]').text("N/A");
            element.find('[data-task-myscore-section] [data-task-myscore-paragraph]').text(data.homeCollectionItems[counter-1].myScore.value);
            $.each(data.homeCollectionItems[counter-1].langs, function(key,val) {
                if(data.homeCollectionItems[counter-1].langs.length - 1 == key) {
                    var separator = "";
                } else {
                    var separator = ", "
                }
                element.find('[data-task-languages-section] [data-task-languages-paragraph]').append(val.value + separator);
            });
            $.each(data.homeCollectionItems[counter-1].forms, function(key,val) {
                console.log(val.value);
                element.find('[data-task-form-section] [data-task-form-paragraph]')
                .html('<a th:href="${user.getId()}" data-task-form-value-section data-task-id="0"><img src="' + forms[val.value] + '" height="22" width="22"/></a>');
            })
            element.find('[data-task-edit-section]').click(function () {
            });

            return element;
        };

        getAll(urlType);
        $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
    }