const Request = {};
Request.request = function (method, url, data, config) {
    return new Promise(function (resolve, reject) {
        let AJAX = new XMLHttpRequest();
        AJAX.responseType = "json";
        AJAX.timeout = 20000;
        AJAX.open(method, location.origin + url);
        AJAX.send(data);
        AJAX.onreadystatechange = function () {
            if (AJAX.readyState === 4) {
                return resolve(AJAX.response);
            }
        }
    }).catch(error => {
        console.log(error);
        return Promise.reject(error);
    });
};

Request.get = function (url, data = {}, config = {}) {
    return Request.request("GET", url, data, config);
};

Request.post = function (url, data = {}, config = {}) {
    return Request.request("POST", url, data, config);
};