if (window.location.href.indexOf("collections") != -1) {
        var urlType = "collections/user";
        const forms = {
            EBOOK: '/img/ebook.png',
            PAPER: '/img/book.png'
        }
        function createData(data, counter) {
            const elements = {};
            $.each(data.homeCollectionItems, function(ikey, item) {
                const element = $(datatableRowTemplate).clone();
                element.attr('data-task-id', item.id);
                //            element.find('[data-task-series] [data-task-series-paragraph]').text(data.homeCollectionItems[counter-1].book.series);

                            element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter++);
                            element.find('[data-task-year-section] [data-task-year-paragraph]').text(item.book.year);
                            element.find('[data-task-title-section] [data-task-title-paragraph]').text(item.book.title);
                            element.find('[data-task-titleENG-section] [data-task-titleENG-paragraph]').text(item.book.titleEng);
                            element.find('[data-task-genre-section] [data-task-genre-paragraph]').text(item.book.genre);
                            element.find('[data-task-worldscore-section] [data-task-worldscore-paragraph]').text("N/A");
                            element.find('[data-task-myscore-section] [data-task-myscore-paragraph]').text(item.myScore.value);
                            $.each(item.langs, function(key,val) {
                                if(item.langs.length - 1 == key) {
                                    var separator = "";
                                } else {
                                    var separator = ", "
                                }
                                element.find('[data-task-languages-section] [data-task-languages-paragraph]').append(val.value + separator);
                            });
                            $.each(item.forms, function(key,val) {
                                console.log(val.value);

                                element.find('[data-task-form-section] [data-task-form-paragraph]')
                                .append('<a th:href="${user.getId()}" data-task-form-value-section data-task-id="' + key + '"><img src="' + forms[val.value] + '" height="22" width="22"/></a>');
                            })
                            element.find('[data-task-edit-section]').click(function () {
                            });
                elements["key" + ikey] = element;
            });
            console.log(elements);
            return elements;
        };

        getAll(urlType);
        $tasksContainer.on('click','[data-task-delete-button]', {urlType: urlType},handleDeleteRequest);
    }