<?php
// 生成一个PHP数组
$data = array();
$data['a'] = 'te';
$data['b'] = 'bbb';

// 把PHP数组转成JSON字符串
$json_string = json_encode($data);

// 写入文件
file_put_contents('test.json', $json_string);




$json_string = file_get_contents('test.json');

// 把JSON字符串转成PHP数组
$data = json_decode($json_string, true);

// 显示出来看看
var_dump($data);
?>