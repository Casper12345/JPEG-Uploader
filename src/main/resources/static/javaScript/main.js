function hello() {
  alert("hell0");
}

function clearAttributes() {
  $("#file").val("");
  $("#inner").val("");
  $('#inner2').empty();
}

// get folder name
function selectFolder(e) {
  var theFiles = e.target.files;
  var relativePath = theFiles[0].webkitRelativePath;
  var folder = relativePath.split("/");
  setInner(folder[0]);
}

// post
function post() {

  var data = sortFilesByExtension();

  postFiles(data);
}

// sort files
function sortFilesByExtension() {

  var data = new FormData();

  $.each($("input[type='file']")[0].files, function (i, file) {

    var fileExtension = file['name'].split('.')[1];

    if (fileExtension === 'jpeg' || fileExtension === 'jpg') {
      data.append('file', file);
    }

  });
  return data;
}

// post files
function postFiles(data) {
  $.ajax({
    type: 'POST',
    url: '/',
    cache: false,
    contentType: false,
    processData: false,
    data: data,

    success: function (result) {
      location.href = "/"
    }
  });
}

// set folder name
function setInner(folderName) {
  $("#inner").val(folderName);
}

