/**
 * 공통 기능 모음
 */
function getParamByLocation() {
	var params = new Array(), keys = new Array(), values = new Array();
	if (location.search) {
		var parameter = location.search;
		var paramIndex = parameter.indexOf("?");
		parameter = parameter.substring(paramIndex + 1);
		for (var i = 0; location.search.split("&")[i]; i++) {
			params[i] = parameter.split("&")[i];
			keys[i] = params[i].split("=")[0];
			values[i] = params[i].split("=")[0];
		}
	}
}

function isEmpty(val) {
	if (val == undefined) {
		return true;
	}
	if (val.trim().length == 0 || val == null) {
		return true;
	}
}