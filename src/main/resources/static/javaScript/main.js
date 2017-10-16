/**
 * Function for clearing attributes.
 * Clears file input, both text fields and cookie.
 */
function clearAttributes() {
  $("#file").val("");
  $("#inner").val("");
  $('#inner2').empty();
  clearCookie();
}

/**
 * Function for getting folder name from file path and
 * returning it as a string.
 * @param input from event.
 */
function selectFolder(input) {
  var theFiles = input.target.files;
  var relativePath = theFiles[0].webkitRelativePath;
  var folder = relativePath.split("/");
  setInner(folder[0]);
}

/**
 * Controller function for posting files.
 * Collects functionality from file filtering and post.
 * Calls postFiles and filterFilesByExtension.
 */
function controllerPost() {

  if ($('#file').val() === '') {
    alert('Please choose a folder to upload');
  } else {
    postFiles(filterFilesByExtension());
  }

}

/**
 * Function for filtering files by file extensions as string.
 * @returns FormData with filtered files.
 */
function filterFilesByExtension() {

  var data = new FormData();

  $.each($("input[type='file']")[0].files, function (i, file) {

    var fileExtension = file['name'].split('.')[1];

    if (fileExtension === 'jpeg' || fileExtension === 'jpg') {
      data.append('file', file);
    }

  });
  return data;
}

/**
 * Function for sending multipart files as array by POST request.
 * @param data array of multipart files.
 */
function postFiles(data) {
  $.ajax({
    type: 'POST',
    url: '/',
    cache: false,
    contentType: false,
    processData: false,
    data: data,

    success: function (result) {
      location.href = "/completed"
    }
  });
}

/**
 * Function for setting folder name in first text field.
 * @param folderName name of folder as string.
 */
function setInner(folderName) {
  $("#inner").val(folderName);
}

/**
 * Function for clearing cookie.
 */
function clearCookie() {
  document.cookie = 'message=; path=/completed; expires='
      + new Date(0).toUTCString();
}

/**
 * Destroys cookie on page refresh.
 */
$(window).unload(function () {
  clearCookie();
});

