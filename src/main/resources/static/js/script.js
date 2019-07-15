$(document).ready(function() {

  //const apiRoot = 'https://tasks-aku.herokuapp.com/v1/tasks';
  const apiRoot = 'http://localhost:8080/v1/';
  const datatableRowTemplate = $('[data-datatable-row-template]');//.children()[0];
  const $tasksContainer = $('[data-tasks-container]');
  var counter = 1;

  //var availableTasks = {};

  // init
  if (window.location.href.indexOf("authors") != -1) {
    getAllAuthors();
  }
  if (window.location.href.indexOf("books") != -1) {
    getAllBooks();
  }
  

  function createAuthor(data) {
    const element = $(datatableRowTemplate).clone();

    element.attr('data-task-id', data.id);
    element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter++);
    element.find('[data-task-name-section] [data-task-name-paragraph]').text(data.name);
    element.find('[data-task-content-section] [data-task-content-paragraph]').text(data.surname);
    element.find('[data-task-country-section] [data-task-country-paragraph]').text(data.country);
    element.find('[data-task-city-section] [data-task-city-paragraph]').text(data.city);
    element.find('[data-task-birth-section] [data-task-birth-paragraph]').text(data.yearOfBirth);
    element.find('[data-task-books-section]').click(function() {console.log("dd");});

    return element;
  }

  function getAllAuthors() {
    const requestUrl = apiRoot + 'authors';

    $.ajax({
      url: requestUrl,
      method: 'GET',
      contentType: "application/json",
      success: function(tasks) {
        tasks.forEach(task => {
          //availableTasks[task.id] = task;
          createAuthor(task).appendTo($tasksContainer);
          console.log(task);
        });
      }
    });
  }

function createBook(data) {
    const element = $(datatableRowTemplate).clone();

    element.attr('data-task-id', data.id);
    element.find('[data-task-counter] [data-task-counter-paragraph]').text(counter++);
    element.find('[data-task-titlePL-section] [data-task-titlePL-paragraph]').text(data.titlePl);
    element.find('[data-task-titleEN-section] [data-task-titleEN-paragraph]').text(data.titleEn);
    element.find('[data-task-series-section] [data-task-series-paragraph]').text(data.series);
    element.find('[data-task-genre-section] [data-task-genre-paragraph]').text(data.genre);
    element.find('[data-task-year-section] [data-task-year-paragraph]').text(data.year);
    element.find('[data-task-authors-section]').click(function() {console.log("dd");});

    return element;
  }

  function getAllBooks() {
    const requestUrl = apiRoot + 'books';

    $.ajax({
      url: requestUrl,
      method: 'GET',
      contentType: "application/json",
      success: function(tasks) {
        tasks.forEach(task => {
          //availableTasks[task.id] = task;
          createBook(task).appendTo($tasksContainer);
          console.log(task);
        });
      }
    });
  }
});
