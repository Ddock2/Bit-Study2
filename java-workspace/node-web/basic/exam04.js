/**
 *	내장 모듈 path 사용
 */
var path = require('path');

var directories = ['users', 'docs', 'bit'];
var doDirectory = directories.join(path.sep);

console.log('디렉토리 명 : %s', doDirectory);

// 디렉토리 이름과 파일 이름 붙이기
var curPath = path.join(__dirname, __filename);
console.log('파일 경로 : %s', curPath);

// 파일 경로에서 디렉토리, 파일 이름, 확장자 구별
var filename = __filename;
var dirname = path.dirname(filename);
var basename = path.basename(filename);
var extname = path.extname(filename);

console.log('디렉토리 : %s \n파일이름 : %s \n확장자 : %s', dirname, basename, extname);